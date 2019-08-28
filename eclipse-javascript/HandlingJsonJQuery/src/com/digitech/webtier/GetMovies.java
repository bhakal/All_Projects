package com.digitech.webtier;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digitech.businesstier.MovieManager;
import com.digitech.businesstier.MovieTO;
import com.google.gson.Gson;


@WebServlet("/GetMovies")
public class GetMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		MovieManager manager=new MovieManager();
		List<MovieTO> movieList=manager.getAllMovies();
		if(movieList.size() != 0){
			Gson gson = new Gson();
			String movies= gson.toJson(movieList);
			
			out.println("{\"MoviesList\":"+movies+"}");			
			
		}else{
			out.println("<html><body<h1>"+"No Records Found"+"</h1></body></html>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
