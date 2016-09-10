
package br.edu.ifsp.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private String url = "jdbc:derby://localhost:1527/blogdb";
    private String username = "root";
    private String password =    "root";
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    
}
