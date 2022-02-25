package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Pet;
import com.repo.PetDao;

/**
 * Servlet implementation class AddPet
 */
@WebServlet("/AddPet")
public class AddPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPet() {
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

		String name=request.getParameter("name");  
        String photo=request.getParameter("photo");
        int category=Integer.parseInt(request.getParameter("category"));
        int tag=Integer.parseInt(request.getParameter("tag"));
        String status=request.getParameter("status"); 
        Pet pet=new Pet();  
        pet.setName(name);  
        pet.setPhoto(photo);  
        pet.setCategory(category);  
        pet.setTag(tag);
        pet.setStatus(status);  
        try {
			PetDao.insertPet(pet);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
        out.print("New Record Added Successfully");
        response.sendRedirect("list.jsp");
	}

}

