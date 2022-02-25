package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.repo.PetDao;

/**
 * Servlet implementation class DeletePet
 */
@WebServlet("/DeletePet")
public class DeletePet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePet() {
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
		try {
				PetDao.deletePet(id);
		} 
		catch (SQLException e) {
				e.printStackTrace();
				
		}  
        out.print("Record Deleted Successfully");
        response.sendRedirect("list.jsp");
	}

}


