
package br.edu.ifsp.blog.servlets;

import br.edu.ifsp.blog.dao.UserDAO;
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


@WebServlet(name = "PostRead", urlPatterns = {"/post/read", "/post/read.do"})
public class PostRead extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            
            User user = new User(name, email);
            UserDAO dao = new UserDAO();
            dao.insert(user);
            
            req.setAttribute("user", user);
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






