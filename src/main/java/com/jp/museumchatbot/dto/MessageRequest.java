package com.jp.museumchatbot.dto;

public record MessageRequest(String message) {

}

/**
 * Nesse caso o record está sendo usado pois ele
 * é uma representação de um objeto e não necessáriamente
 * ele terá métodos implementados. Ou seja é so uma classe
 * que vai transitar dados.
 * Por padrão o record tem os getters and setters
 */