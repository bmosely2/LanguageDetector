package com.example.myapplication;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class LanguageDetector {
    public static String getLanguage (final String json) {
        JsonParser parser = new JsonParser() ;
        JsonObject result = parser.parse(json).getAsJsonObject();
        if (result.get("success").equals(true)) {
            JsonArray array = result.get("results").getAsJsonArray();
            JsonObject code = array.get(0).getAsJsonObject();
            String languageCode = code.get("language_code").getAsString();
            return languageCode;
        }
        return null;
    }
}
