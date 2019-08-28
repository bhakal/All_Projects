package com.digitech.webtier;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digitech.businesstier.MovieManager;
import com.digitech.businesstier.MovieTO;


@WebServlet("/InsertMovie")
public class InsertMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String message=request.getParameter("message");
		if(message.length()>0){
			MovieTO movieTO=new MovieTO();
			movieTO.setMovie_name(message);
			MovieManager manager=new MovieManager();
			String result=manager.insertMovie(movieTO);
			out.println("<html><body>"+result+"</body></html>");
			System.out.println(result);
		}else{
			out.println("<html><body>"+"Enter Movie Name"+"</body></html>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
