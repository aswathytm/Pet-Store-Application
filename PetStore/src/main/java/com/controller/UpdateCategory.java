package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Category;

import com.repo.CategoryDao;


/**
 * Servlet implementation class UpdatePet
 */
@WebServlet("/UpdateCategory")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
		String name=request.getParameter("name");  
        Category category1=new Category(); 
       category1.setId(id);
        category1.setCategory_name(name);  
        
        try {
			CategoryDao.updateCategory(category1);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
        out.print("New Record Updated Successfully");
        response.sendRedirect("category.jsp");
	}
}




