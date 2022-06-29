package com.arthurolg.patterns.structural.adapter;

public class Adapter {
    public static void main(String[] args) {
        MySQLConnectionInterface database = new DatabaseAdapter(new MongoConnection());
        database.connection();
        System.out.println(database.runQuery());
    }
}
