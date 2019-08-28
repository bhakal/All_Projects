package com.digitech.persistencetier;

import java.util.List;

import com.digitech.businesstier.MovieTO;

public interface IMovie {
	public String insertMovie(MovieTO movieTO);
	public MovieTO getMovieById(Integer id);
	public List<MovieTO> getAllMovies();
}
