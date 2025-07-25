package E01_Products_Shop.service.implementations;

import E01_Products_Shop.service.utilities.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.*;
import com.google.gson.*;
import org.springframework.stereotype.*;

import java.io.*;

@Service
public class ExportUtilityImpl implements ExportUtility {

    private static final String GSON_DEFAULT_LOCATION = "06_Spring_Data/08_Spring_Data_JSON_XML_Processing/E01_Products_Shop/src/main/resources/json/exports/";
    private static final String XML_DEFAULT_LOCATION = "06_Spring_Data/08_Spring_Data_JSON_XML_Processing/E01_Products_Shop/src/main/resources/xml/exports/";

    private final Gson gson;
    private final ObjectMapper objectMapper;
    private final XmlMapper xmlMapper;

    public ExportUtilityImpl(Gson gson, ObjectMapper objectMapper, XmlMapper xmlMapper) {
        this.gson = gson;
        this.objectMapper = objectMapper;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public <E> void exportJSONCollectionWithJackson(Iterable<E> data, String fileName) {
        File file = createFile(fileName);
        try {
            objectMapper.writer().withDefaultPrettyPrinter().writeValue(file, data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to JSON file: " + file.getPath(), e);
        }
    }

    @Override
    public <E> void exportJSONWithJackson(E data, String fileName) {
        File file = createFile(fileName);
        try {
            objectMapper.writer().withDefaultPrettyPrinter().writeValue(file, data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to JSON file: " + file.getPath(), e);
        }
    }

    @Override
    public <E> void exportJSONCollectionWithGson(Iterable<E> data, String fileName) {
        File file = createFile(fileName);
        String jsonString = gson.toJson(data);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonString);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to JSON file: " + file.getPath(), e);
        }
    }

    @Override
    public <E> void exportJSONWithGson(E data, String fileName) {
        File file = createFile(fileName);
        String jsonString = gson.toJson(data);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonString);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to JSON file: " + file.getPath(), e);
        }
    }

    @Override
    public <E> void exportXMLCollection(Iterable<E> data, String fileName) {
        File file = createFile(fileName);
    }

    @Override
    public <E> void exportXML(E data, String fileName) {

    }

    @Override
    public File createFile(String fileName) {
        String fullPath = GSON_DEFAULT_LOCATION + fileName + ".json";
        return new File(fullPath);
    }
}
