package core.utils;

import java.io.InputStream;
import java.util.List;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {
    private static final ObjectMapper objectMapper =
            new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static <T> List<T> readJsonList(String path, Class<T[]> clazz) {
        try {
            InputStream json = JsonReader.class.getClassLoader().getResourceAsStream(path);
            T[] aList = objectMapper.readValue(json, clazz);
            return List.of(aList);
        } catch (Exception e) {
            throw new RuntimeException("Could not read JSON file: " + path, e);
        }
    }

    public static <T> T readJson(String path, Class<T> clazz) {
        try {
            InputStream json = JsonReader.class.getClassLoader().getResourceAsStream(path);
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Could not read JSON file: " + path, e);
        }
    }

    public static <T> T readJsonByKey(String path, Class<T> clazz, String key) {
        try {
            InputStream json = JsonReader.class.getClassLoader().getResourceAsStream(path);
            var node = objectMapper.readTree(json).get(key);
            return objectMapper.treeToValue(node, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Could not read JSON file: " + path, e);
        }
    }
}
