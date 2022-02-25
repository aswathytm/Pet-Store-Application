package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.repo.LoginDao;
import com.service.Login;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Login login;
	 public void init() {
	        login = new Login();
	    }
	    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        try {
            if (login.validate(loginUser)) {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                response.sendRedirect("list.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


