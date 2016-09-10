
package br.edu.ifsp.blog.dao;

import br.edu.ifsp.blog.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDAO {
    private Connection conn;
    
    public UserDAO() throws SQLException {
        Database db = new Database();
        this.conn = db.getConnection();
    }
    
    // este método será chamado logo antes da destruição da instância desta classe
    @Override
    public void finalize() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO tbUSER(name, email) VALUES(?, ?)";
        
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getEmail());
        
        stmt.executeUpdate();
        
        stmt.close();
    }
    
    
    public ArrayList<User> findAll() throws SQLException {
        String sql = "SELECT * FROM tbUSER";
        
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<User> list = new ArrayList<>();
        
        // extraindo as linhas da consulta e criando um Array de Users
        while (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            
            User user = new User(name, email);
            list.add(user);
        }
        
        stmt.close(); // ao fazer isso, tbm fecha/destroy o ResultSet
        
        return list;
    }
}




