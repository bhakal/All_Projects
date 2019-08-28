package com.digitech.businesstier;

import java.util.List;

import com.digitech.persistencetier.MovieService;

public class MovieManager {
	public List<MovieTO> getAllMovies(){
		MovieService service=new MovieService();
		return service.getAllMovies(); 
	}
	
	public String insertMovie(MovieTO movieTO){
		MovieService service=new MovieService();
		return service.insertMovie(movieTO);
	}
}
