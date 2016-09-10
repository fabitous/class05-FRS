package br.edu.ifsp.blog.servlets;

import br.edu.ifsp.blog.dao.UserDAO;
import br.edu.ifsp.blog.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UserAll", urlPatterns = {"/user/index", "/user/index.do"})
public class UserAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDAO dao = new UserDAO();
            
            ArrayList<User> list = dao.findAll();
            
            req.setAttribute("list", list);
            RequestDispatcher disp = req.getRequestDispatcher("/user/all.jsp");
            disp.forward(req, resp);
        } catch (SQLException ex) {
            resp.sendRedirect("error.jsp");
        }
        
    }
    
}



