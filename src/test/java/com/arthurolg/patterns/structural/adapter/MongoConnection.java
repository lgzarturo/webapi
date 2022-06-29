package com.arthurolg.patterns.structural.adapter;

import java.util.UUID;

public class MongoConnection implements MongoConnectionInterface {

    @Override
    public void connection() {
        System.out.println("Conexión con el servidor de mongodb");
    }

    @Override
    public String executeSentence() {
        return "Obteniendo el documento: "+ UUID.randomUUID().toString();
    }
}
