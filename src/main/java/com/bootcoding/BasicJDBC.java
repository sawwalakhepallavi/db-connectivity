package com.bootcoding;
import java.sql.*;
public class BasicJDBC {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String un = "postgres";
        String pass = "root";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, un, pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                int id = rs.getInt("stud_id");
                String name = rs.getString("stud_name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database.", e);
        }
    }
}