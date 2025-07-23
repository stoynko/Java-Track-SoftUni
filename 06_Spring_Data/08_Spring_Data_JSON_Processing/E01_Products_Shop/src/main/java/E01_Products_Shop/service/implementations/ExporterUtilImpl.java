package E01_Products_Shop.service.implementations;

import E01_Products_Shop.service.dtos.*;
import E01_Products_Shop.service.utilities.*;
import com.fasterxml.jackson.databind.*;
import com.google.gson.*;
import org.springframework.stereotype.*;

import java.io.*;

@Service
public class ExporterUtilImpl implements ExporterUtil {

    private static final String DEFAULT_LOCATION = "06_Spring_Data/08_Spring_Data_JSON_Processing/E01_Products_Shop/src/main/resources/json/exports/";

    Gson gson;
    ObjectMapper objectMapper;

    public ExporterUtilImpl(Gson gson, ObjectMapper objectMapper) {
        this.gson = gson;
        this.objectMapper = objectMapper;
    }

    @Override
    public <E> void exportWithGson(Iterable<E> data, String fileName) {
        String fullPath = DEFAULT_LOCATION + fileName + ".json";
        String jsonString = gson.toJson(data);
        File file = new File(fullPath);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonString);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to JSON file: " + fullPath, e);
        }
    }

    @Override
    public <E> void exportWithJackson(Iterable<E> data, String fileName) {
        String fullPath = DEFAULT_LOCATION + fileName + ".json";
        File file = new File(fullPath);
        try {
            objectMapper.writer().withDefaultPrettyPrinter().writeValue(file, data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to JSON file: " + fullPath, e);
        }
    }


}
