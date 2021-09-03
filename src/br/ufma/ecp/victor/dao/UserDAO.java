package br.ufma.ecp.victor.dao;

import br.ufma.ecp.victor.user.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

    private Connection conn;

    private String url = "jdbc:mysql://localhost:3306/user_registration";
    private String user = "root";
    private String pass = null;

    public UserDAO(){
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected!");

        } catch (SQLException e) {
            System.out.println("OPS! Connection cannot be established :(");
        }
    }

    public void createUser(User user){ // it works!
        String sql = "INSERT INTO user_registration (id, username, email) VALUES(?, ?, ?)";

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.execute();
            System.out.println("User was registered.");
        }catch(SQLException e) {
            System.out.println("OPS! Was not possible to add :(");
        }
    }

    public void deleteUser(User user) {
        String sql = "DELETE FROM user_registration WHERE id = (?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            stmt.execute();
            System.out.println("User was deleted!");
        } catch (SQLException e) {
            System.out.println("OPS! Was not possible to delete :(");
        }

    }

}
