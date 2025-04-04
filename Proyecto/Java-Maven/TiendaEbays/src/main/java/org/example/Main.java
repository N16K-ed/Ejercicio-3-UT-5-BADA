package org.example;

import org.example.dbconnection.Connect;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connect conn = new Connect();
        conn.conectar();
    }
}