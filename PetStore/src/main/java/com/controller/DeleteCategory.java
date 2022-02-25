package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.repo.CategoryDao;

/**
 * Servlet implementation class DeleteCategory
 */
@WebServlet("/DeleteCategory")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();

		String sid=request.getParameter("id");  
     
		int id=Integer.parseInt(sid);
		try {
				CategoryDao.deleteCategory(id);
		} 
		catch (SQLException e) {
				e.printStackTrace();
		}  
        out.print("Record Deleted Successfully");
        response.sendRedirect("category.jsp");
	}

}


