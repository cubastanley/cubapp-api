/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish.payara.cubappmessenger.service;

import fish.payara.cubappmessenger.base.User;
import java.sql.Connection;
import java.sql.DriverManager;
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
    
    public User getUserById(String id) {
        return new User(id, "firstname here", "surname here");
    }
    
    public List<User> getUsers() {
        List<User> uList = new ArrayList<>();
        uList.add(new User("username 1", "firstname here", "surname here"));
        uList.add(new User("username 2", "firstname here", "surname here"));
        uList.add(new User("username 3", "firstname here", "surname here"));
        
        return uList;
        
    }
    
}
