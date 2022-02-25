package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PetStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public PetStore() {
        super();
        
    }

public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("petname");
		String petid = request.getParameter("petid");
		out.println("Get Method");
		out.println("Pet Name : " + name);
		out.println("Get Method : " + petid);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		out.println("Post Method");
		String petname = request.getParameter("petname");
		out.println("Pet Name : " + petname +" is added to the store" );
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		out.println("Put Method");
		String petname = request.getParameter("petname");
		out.println("Pet Name : " + petname +" is updated" );
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		String petid = request.getParameter("petid");
		out.println("Delete Pet with ID :" + petid );
		
	}
}


