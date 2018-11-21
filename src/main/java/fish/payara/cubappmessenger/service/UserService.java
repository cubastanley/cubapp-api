/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.cubappmessenger.service;

import fish.payara.cubappmessenger.base.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cubsy
 */
public class UserService {
    
    Connection con = null;
    
    public UserService() {
        
        String url, username, password;
        url = "jdbc:mysql://localhost:3306/Cubapp";
        username = "root";
        password = "Huskyanna234";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public List<User> getAllUsers() {
        
        List<User> users = new ArrayList<>();
        String sql = "select * from Users";
        try {
            //Statement statement = con.createStatement();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                User u = new User();
                u.setUsername(rs.getString("username"));
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                
                users.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return users;
    }
    
    public User getUserById(String id) {
        
        User u = new User();
        String sql = "select * from Users where username="+id ;
        try {
           // Statement statement = con.createStatement();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()) {
                
                u.setUsername(rs.getString("username"));
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return u;
    }
    
    public User addUser(User user) {
        String sql = "insert into Users values (?,?,?)";
        try {
            //PreparedStatement statement = con.prepareStatement(sql);
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            
            statement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return user;
    }
    
}
