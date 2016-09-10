
package br.edu.ifsp.blog.dao;

import br.edu.ifsp.blog.models.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PostDAO {
    private Connection conn;
    
    public PostDAO() throws SQLException {
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
    
    public void insert(Post post) throws SQLException {
        String sql = "INSERT INTO tbPOST(description, emailUser) VALUES(?, ?, ?)";
        
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setInt(1, post.getID());
        stmt.setString(2, post.getDescription());
        stmt.setString(3, post.getEmailUser());
        
        stmt.executeUpdate();
        
        stmt.close();
    }
    
    public int getID() throws SQLException {
        int ID = 0;
        String sql = "select MAX(ID) from tbPOST)";
        PreparedStatement stmt = this.conn.prepareStatement(sql);      
        ResultSet rs = stmt.executeQuery();
        ID = rs.getInt(0);
        ID++;
        stmt.close();
        return ID;
    }
}




