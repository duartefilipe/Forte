package br.forte.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection getConexao() throws ClassNotFoundException{
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url ="jdbc:postgresql://192.168.199.131:5432/postgres";
            String user="forte";
            String password = "Forte2018@@";
            c = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            Class.forName("org.postgresql.Driver");
//            String url ="jdbc:postgresql://localhost:5433/forte";
//            String user="postgres";
//            String password = "1234";
//            c = DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return c;
    }
}