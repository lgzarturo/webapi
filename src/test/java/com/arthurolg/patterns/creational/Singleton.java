package com.arthurolg.patterns.creational;

public class Singleton {
    public static void main(String[] args) {
        var connection =  DbConnection.createConnection();
        System.out.println(connection.hashCode());
        var otherConnection = DbConnection.createConnection();
        System.out.println(otherConnection.hashCode());
    }
}

class DbConnection {

    private static DbConnection connection;
    private DbConnection() {}
    public static DbConnection createConnection() {
        if (connection == null) {
            connection = new DbConnection();
        }
        return connection;
    }
}
