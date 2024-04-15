package com.pedruuv.sound.service;

public interface IConvertData {
    <T> T obterDados(String json, Class<T> datClass);
}
