package E01_Products_Shop.service.implementations;

import E01_Products_Shop.data.*;
import E01_Products_Shop.data.dtos.*;
import E01_Products_Shop.repositories.*;
import E01_Products_Shop.service.*;
import E01_Products_Shop.service.utilities.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.google.gson.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.math.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCTS_JSON_PATH_JACKSON = "json/imports/products.json";
    private static final String PRODUCTS_JSON_PATH_GSON = "06_Spring_Data/08_Spring_Data_JSON_Processing/E01_Products_Shop/src/main/resources/json/products.json";

    private final UserService userService;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;
    private final Gson gson;
    private final CategoryService categoryService;
    private final ExportUtility exporter;

    @Autowired
    public ProductServiceImpl(UserService userService, ProductRepository productRepository, ModelMapper modelMapper, ObjectMapper objectMapper, Gson gson, CategoryService categoryService, ExportUtility exporter) {
        this.userService = userService;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
        this.gson = gson;
        this.categoryService = categoryService;
        this.exporter = exporter;
    }

    @Override
    public void importDataWithJackson() {
        try {
            InputStream inputStream = new ClassPathResource(PRODUCTS_JSON_PATH_JACKSON).getInputStream();
            Set<ImportProductDTO> inputProducts = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
            for (ImportProductDTO productDTO : inputProducts) {
                Product product = modelMapper.map(productDTO, Product.class);
                product.setCategory(categoryService.getRandomCategories());
                product.setSeller(userService.getRandomUser());

                boolean randomBool = ThreadLocalRandom.current().nextBoolean();
                if (randomBool) {
                    product.setBuyer(userService.getRandomUser());
                }
                productRepository.saveAndFlush(product);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load or parse JSON file with path: " + PRODUCTS_JSON_PATH_JACKSON, e);
        }
    }

    @Override
    public void importDataWithGSON() {
        try {
            String inputData = String.join("", Files.readAllLines(Path.of(PRODUCTS_JSON_PATH_GSON)));
            ImportProductDTO[] importProducts = gson.fromJson(inputData, ImportProductDTO[].class);
            for (ImportProductDTO productDTO : importProducts) {
                Product product = modelMapper.map(productDTO, Product.class);
                product.setCategory(categoryService.getRandomCategories());
                product.setSeller(userService.getRandomUser());

                boolean randomBool = ThreadLocalRandom.current().nextBoolean();
                if (randomBool) {
                    product.setBuyer(userService.getRandomUser());
                }
                productRepository.saveAndFlush(product);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load or parse JSON file with path: " + PRODUCTS_JSON_PATH_GSON, e);
        }
    }

    @Override
    public boolean isImported() {
        return productRepository.count() > 0;
    }

    @Override
    public void exportProductsInRange(BigDecimal lowerBound, BigDecimal upperBound) {
        Set<Product> productsInRange = productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lowerBound, upperBound);

        List<ExportProductGsonDTO> productDTOsInRange = productsInRange.stream().map(product -> {
            ExportProductGsonDTO productDTO = modelMapper.map(product, ExportProductGsonDTO.class);
            if (product.getSeller().getFirstName() == null) {
                productDTO.setSellerNames(product.getSeller().getLastName());
            } else {
                productDTO.setSellerNames(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());
            }
            return productDTO;
        }).collect(Collectors.toList());
        exporter.exportJSONWithGson(productDTOsInRange, "products-in-range-gson");
        exporter.exportJSONWithJackson(productDTOsInRange, "products-in-range-jackson");
    }
}
