package E02_Car_Dealer.services.implementations;

import E02_Car_Dealer.services.utilities.*;
import com.google.gson.*;
import com.fasterxml.jackson.databind.*;
import org.springframework.stereotype.*;

import java.io.*;

@Service
public class ExportUtilityImpl implements ExportUtility {

    private static final String DEFAULT_LOCATION = "06_Spring_Data/08_Spring_Data_JSON_XML_Processing/E02_Car_Dealer/src/main/resources/json/exports/";

    private final Gson gson;
    private final ObjectMapper objectMapper;

    public ExportUtilityImpl(Gson gson, ObjectMapper objectMapper) {
        this.gson = gson;
        this.objectMapper = objectMapper;
    }

    @Override
    public <E> void exportCollectionWithJackson(Iterable<E> data, String fileName) {
        File file = createFile(fileName);
        try {
            objectMapper.writer().withDefaultPrettyPrinter().writeValue(file, data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to JSON file: " + file.getPath(), e);
        }
    }

    @Override
    public <E> void exportWithJackson(E data, String fileName) {
        File file = createFile(fileName);
        try {
            objectMapper.writer().withDefaultPrettyPrinter().writeValue(file, data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to JSON file: " + file.getPath(), e);
        }
    }

    @Override
    public <E> void exportCollectionWithGson(Iterable<E> data, String fileName) {
        File file = createFile(fileName);
        String jsonString = gson.toJson(data);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonString);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to JSON file: " + file.getPath(), e);
        }
    }

    @Override
    public <E> void exportWithGson(E data, String fileName) {
        File file = createFile(fileName);
        String jsonString = gson.toJson(data);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonString);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to JSON file: " + file.getPath(), e);
        }
    }

    @Override
    public File createFile(String fileName) {
        String fullPath = DEFAULT_LOCATION + fileName + ".json";
        return new File(fullPath);
    }
}
