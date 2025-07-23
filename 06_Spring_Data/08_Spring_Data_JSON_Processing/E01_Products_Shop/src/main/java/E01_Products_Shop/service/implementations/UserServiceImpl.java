package E01_Products_Shop.service.implementations;

import E01_Products_Shop.data.*;
import E01_Products_Shop.repositories.*;
import E01_Products_Shop.service.*;
import E01_Products_Shop.service.dtos.*;
import E01_Products_Shop.service.utilities.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.google.gson.*;
import jakarta.persistence.*;
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
    private final ExporterUtil exporterUtil;

    private UserRepository userRepository;
    private ValidatorUtil validatorUtil;
    private ObjectMapper objectMapper;
    private Gson gson;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ValidatorUtil validatorUtil, ObjectMapper objectMapper, Gson gson, ModelMapper modelMapper, ExporterUtil exporterUtil) {
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.objectMapper = objectMapper;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.exporterUtil = exporterUtil;
    }

    @Override
    public void importDataWithJackson() {
        try {
            InputStream inputStream = new ClassPathResource(USERS_JSON_PATH_JACKSON).getInputStream();
            Set<ImportUserDTO> inputUsers = objectMapper.readValue(inputStream, new TypeReference<>() { });
            for (ImportUserDTO userDTO : inputUsers) {
                if (!validatorUtil.isValid(userDTO)) {
                    System.out.println(validatorUtil.getViolations(userDTO));
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
                if (!validatorUtil.isValid(userDTO)) {
                    System.out.println(validatorUtil.getViolations(userDTO));
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

        List<ExportUserSoldProductsDTO> usersWithSoldProducts = users.stream().map(user -> {
            ExportUserSoldProductsDTO userDTO = modelMapper.map(User.class, ExportUserSoldProductsDTO.class);

            List<ExportSoldProductDTO> productsDTO = user.getSold().stream()
                    .filter(product -> product.getBuyer() != null)
                    .map(product -> {
               ExportSoldProductDTO productDTO = new ExportSoldProductDTO();
               productDTO.setName(product.getName());
               productDTO.setPrice(product.getPrice());
               if (product.getBuyer().getFirstName() != null) {
                   productDTO.setBuyerFirstName(product.getBuyer().getFirstName());
               }
               productDTO.setBuyerLastName(product.getBuyer().getLastName());
               return productDTO;
           }).toList();
           userDTO.setSoldProducts(productsDTO.toArray(new ExportSoldProductDTO[0]));
           return userDTO;
        }).toList();

        exporterUtil.exportWithJackson(usersWithSoldProducts, "users-with-sold-products-jackson");
    }
}
