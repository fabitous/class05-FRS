
package br.edu.ifsp.blog.servlets;

import br.edu.ifsp.blog.dao.PostDAO;
import br.edu.ifsp.blog.models.Post;

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


@WebServlet(name = "PostNew", urlPatterns = {"/post/new", "/post/new.do"})
public class PostNew extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PostDAO dao = new PostDAO();
            
            String description = req.getParameter("description");
            String emailUser = req.getParameter("emailUser");
            int ID = dao.getID();
            
            Post post = new Post(description, emailUser, ID);
            dao.insert(post);
            
            req.setAttribute("post", post);
            RequestDispatcher disp = req.getRequestDispatcher("/post/show.jsp");
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






