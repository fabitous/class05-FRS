
package br.edu.ifsp.blog.dao;

import br.edu.ifsp.blog.models.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CommentDAO {
    private Connection conn;
    
    public CommentDAO() throws SQLException {
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
    
    
    public void insert(Comment comment) throws SQLException {
        String sql = "INSERT INTO tbCOMMENT(description, idPost) VALUES(?, ?)";
        
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, comment.getDescription());
        stmt.setInt(2, comment.getIdPost());
        
        stmt.executeUpdate();
        
        stmt.close();
    }
    
}




