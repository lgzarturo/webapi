package com.arthurolg.patterns.structural.adapter;

public class MySQLConnection implements MySQLConnectionInterface {
    @Override
    public void connection() {
        System.out.println("Conexión existosa a MySQL");
    }

    @Override
    public String runQuery() {
        return "Consulta a una tabla";
    }
}
