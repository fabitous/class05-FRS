
package br.edu.ifsp.blog.servlets;

import br.edu.ifsp.blog.dao.CommentDAO;
import br.edu.ifsp.blog.dao.UserDAO;
import br.edu.ifsp.blog.models.Comment;
import br.edu.ifsp.blog.models.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CommentNew", urlPatterns = {"/comment/new", "/comment/new.do"})
public class CommentNew extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String description = req.getParameter("description");
            int idPost = Integer.parseInt(req.getParameter("idPost"));
            
            Comment comment = new Comment(description, idPost);
            CommentDAO dao = new CommentDAO();
            dao.insert(comment);
            
            req.setAttribute("comment", comment);
            RequestDispatcher disp = req.getRequestDispatcher("/user/show.jsp");
            disp.forward(req, resp);
        } catch (SQLException ex) {
            resp.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }  
    
}






