package com.arthurolg.patterns.structural.adapter;

public class DatabaseAdapter implements MySQLConnectionInterface {

    private MongoConnectionInterface noSql;
    private MySQLConnectionInterface sql;

    public DatabaseAdapter(Object dbInterface) {
        if (dbInterface instanceof MongoConnection) {
            this.noSql = (MongoConnection) dbInterface;
        } else if (dbInterface instanceof MySQLConnection) {
            this.sql = (MySQLConnection) dbInterface;
        } else {
            throw new RuntimeException("No se puede determinar el origen de los datos");
        }
    }

    @Override
    public void connection() {
        if (this.noSql != null) {
            this.noSql.connection();
        } else if (this.sql != null) {
            this.sql.connection();
        } else {
            throw new RuntimeException("No se ha podido conectar");
        }
    }

    @Override
    public String runQuery() {
        if (this.noSql != null) {
            return this.noSql.executeSentence();
        } else if (this.sql != null) {
            return this.sql.runQuery();
        } else {
            throw new RuntimeException("No se ha podido ejecutar la consulta");
        }
    }
}
