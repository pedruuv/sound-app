package com.pedruuv.sound.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements IConvertData{
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T obterDados(String json, Class<T> datClass) {
        try {
            return mapper.readValue(json, datClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
