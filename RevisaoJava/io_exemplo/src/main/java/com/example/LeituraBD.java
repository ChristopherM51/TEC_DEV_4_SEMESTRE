package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class LeituraBD {
    public void exemplo() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "postgres");
            // Tradutor de SQL
            Statement stmt = con.createStatement();
            // Armazenar os resultados
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios ");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " Nome: " + rs.getString("nome")
                        + " Idade: " + rs.getInt("idade"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
