package com.arthurolg.patterns.creational;

public class Singleton {
    public static void main(String[] args) {
        var connection =  DbConnection.createConnection();
        System.out.println(connection.hashCode());
        var otherConnection = DbConnection.createConnection();
        System.out.println(otherConnection.hashCode());

        Thread threadOne = new Thread(() -> {
            var threadOneConnection = DbConnection.createConnection();
            System.out.println("Thread 1: "+threadOneConnection.hashCode());
        });

        Thread threadTwo = new Thread(() -> {
            var threadTwoConnection = DbConnection.createConnection();
            System.out.println("Thread 2: "+threadTwoConnection.hashCode());
        });

        threadOne.start();
        threadTwo.start();
    }
}

class DbConnection {
    private static DbConnection connection;
    private DbConnection() {}
    public synchronized static DbConnection createConnection() {
        if (connection == null) {
            connection = new DbConnection();
        }
        return connection;
    }
}
