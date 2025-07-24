package E01_Products_Shop.service.implementations;

import E01_Products_Shop.data.*;
import E01_Products_Shop.data.dtos.*;
import E01_Products_Shop.repositories.*;
import E01_Products_Shop.service.*;
import E01_Products_Shop.service.utilities.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.*;
import com.google.gson.*;
import org.modelmapper.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

@Service
public class UserServiceImpl implements UserService {

    private static final String USERS_JSON_PATH_JACKSON = "json/users.json";
    private static final String USERS_JSON_PATH_GSON = "06_Spring_Data/08_Spring_Data_JSON_Processing/E01_Products_Shop/src/main/resources/json/users.json";

    private final UserRepository userRepository;
    private final ValidatorUtility validator;
    private final ExportUtility exporter;
    private final ObjectMapper objectMapper;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final XmlMapper xmlMapper;

    public UserServiceImpl(UserRepository userRepository, ValidatorUtility validator, ObjectMapper objectMapper, Gson gson, ModelMapper modelMapper, ExportUtility exporter, XmlMapper xmlMapper) {
        this.userRepository = userRepository;
        this.validator = validator;
        this.objectMapper = objectMapper;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.exporter = exporter;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public void importDataWithJackson() {
        try {
            InputStream inputStream = new ClassPathResource(USERS_JSON_PATH_JACKSON).getInputStream();
            Set<ImportUserDTO> inputUsers = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
            for (ImportUserDTO userDTO : inputUsers) {
                if (!validator.isValid(userDTO)) {
                    System.out.println(validator.getViolations(userDTO));
                    continue;
                }
                User user = modelMapper.map(userDTO, User.class);
                userRepository.saveAndFlush(user);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load or parse JSON file with path: " + USERS_JSON_PATH_JACKSON, e);
        }
    }

    @Override
    public void importDataWithGSON() {
        try {
            String importData = String.join("", Files.readAllLines(Path.of(USERS_JSON_PATH_GSON)));
            ImportUserDTO[] inputUsers = gson.fromJson(importData, ImportUserDTO[].class);
            for (ImportUserDTO userDTO : inputUsers) {
                if (!validator.isValid(userDTO)) {
                    System.out.println(validator.getViolations(userDTO));
                    continue;
                }
                userRepository.saveAndFlush(modelMapper.map(userDTO, User.class));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load or parse JSON file with path: " + USERS_JSON_PATH_GSON, e);
        }
    }

    @Override
    public boolean isImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public User getRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, this.userRepository.count() + 1);
        return this.userRepository.findById(randomId).get();
    }

    @Override
    public Set<User> getRandomFriends() {
        Set<User> randomFriends = new HashSet<>();
        int randomFriendsCount = ThreadLocalRandom.current().nextInt(1, 4);

        while (randomFriends.size() != randomFriendsCount) {
            long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
            User user = userRepository.findById(randomId).get();
            if (!randomFriends.contains(user)) {
                randomFriends.add(user);
            }
        }
        return randomFriends;
    }

    @Override
    @Transactional
    public void exportUsersWithSoldProducts() {

        Set<User> users = userRepository.findBySoldIsNotNullOrderByLastNameAscFirstNameAsc();

        List<ExportSellerInfoDTO> usersWithSoldProducts = users.stream().map(user -> {
                    ExportSellerInfoDTO userDTO = modelMapper.map(user, ExportSellerInfoDTO.class);
                    Set<ExportSoldProductDTO> productsDTO = user.getSold().stream()
                            .filter(product -> product.getBuyer() != null)
                            .map(product -> {
                                ExportSoldProductDTO productDTO = modelMapper.map(product, ExportSoldProductDTO.class);
                                return productDTO;
                            }).collect(Collectors.toSet());
                    userDTO.setSoldProducts(productsDTO);
                    return userDTO;
                }).filter(userDTO -> !userDTO.getSoldProducts().isEmpty())
                .sorted(Comparator.comparing(ExportSellerInfoDTO::getLastName)
                        .thenComparing(user -> Optional.ofNullable(user.getFirstName()).orElse("")))
                .toList();

        exporter.exportJSONWithJackson(usersWithSoldProducts, "users-with-sold-products-jackson");
        exporter.exportJSONWithGson(usersWithSoldProducts, "users-with-sold-products-gson");
    }

    @Override
    @Transactional
    public void exportUsersWithListedProducts() {
        List<User> data = userRepository.findUsersWithListedProducts();
        List<ExportUsersListedProductsDTO> usersProductsDTO = new ArrayList<>();

        ExportUsersListedProductsDTO usersDTO = new ExportUsersListedProductsDTO();
        usersDTO.setUsersCount(data.size());

        List<ExportSellerWithListedProductsDTO> users = data.stream().map(user -> {

            ExportSellerWithListedProductsDTO userDTO = modelMapper.map(user, ExportSellerWithListedProductsDTO.class);

            List<ExportSoldProductInfoDTO> productsSold = user.getSold().stream()
                    .map(product -> {
                        ExportSoldProductInfoDTO productDTO = modelMapper.map(product, ExportSoldProductInfoDTO.class);
                        return productDTO;
                    }).toList();

            ExportProductInfoDTO productInfoDTO = new ExportProductInfoDTO();
            productInfoDTO.setCount(productsSold.size());
            productInfoDTO.setProducts(productsSold);

            userDTO.setSoldProducts(productInfoDTO);
            return userDTO;
        }).toList();

        usersDTO.setUsers(users);
        usersProductsDTO.add(usersDTO);

        exporter.exportJSONWithJackson(usersProductsDTO, "users-products-jackson");
    }
}