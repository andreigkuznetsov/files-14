package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.CommonData;

import java.io.IOException;
import java.io.InputStream;

public class JsonParser {
    private final CommonData commonData;

    public JsonParser(String jsonFilePath) {
        try (InputStream inputStream = getClass().getResourceAsStream(jsonFilePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("JSON-файл не найден: " + jsonFilePath);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            this.commonData = objectMapper.readValue(inputStream, CommonData.class);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении JSON-файла", e);
        }
    }
    public CommonData getCommonData() {
        return commonData;
    }
}
