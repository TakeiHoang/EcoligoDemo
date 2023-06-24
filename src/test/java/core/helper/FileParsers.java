package core.helper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileParsers<T> {

    public static <T> Object[][] parseJson(String filePath, Class<T> modelClass) throws IOException {
        byte[] jsonData = Files.readAllBytes(Path.of(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> modelList = objectMapper.readValue(jsonData, objectMapper.getTypeFactory().constructCollectionType(List.class, modelClass));

        Object[][] data = new Object[modelList.size()][1];
        for (int i = 0; i < modelList.size(); i++) {
            data[i][0] = modelList.get(i);
        }
        return data;
    }
}
