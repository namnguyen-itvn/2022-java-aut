package com.example.core.helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonHelper {

    public static Object[][] ReadJsonFromFile(String filePath) {
        Object[][] dataProvider;

        try (Reader reader = new FileReader(filePath)) {
            // Read JSON file
            JsonArray data = JsonParser.parseReader(reader).getAsJsonArray();
            JsonObject firstObject = (JsonObject) data.get(0);
            int width = firstObject.size();
            int height = data.size();
            dataProvider = new Object[height][width];

            for (int i = 0; i < height; i++) {
                JsonObject obj = (JsonObject) data.get(i);
                String[] key = obj.keySet().toArray(new String[0]);
                for (int j = 0; j < width; j++) {
                    if (obj == null) {
                        dataProvider[i][j] = "";
                    } else {
                        String dataFromKey = obj.get(key[j]).toString();
                        String optimizeData = dataFromKey.substring(1, dataFromKey.length() - 1);
                        dataProvider[i][j] = optimizeData;
                    }
                }
            }
            return dataProvider;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[0][0];
    }
    
}
