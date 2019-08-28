package com.digitech.persistencetier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.digitech.businesstier.MovieTO;
import com.digitech.utility.MySQLConnection;

public class MovieService implements IMovie{

	@Override
	public String insertMovie(MovieTO movieTO) {
		String sql="insert into movie(movie_name) values(?)";
		try(Connection connection=MySQLConnection.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(sql)	
				){
			preparedStatement.setString(1, movieTO.getMovie_name());
			int n=preparedStatement.executeUpdate();
			if(n>0){
				return "SUCCESS";
			}else{
				return "FAILED";
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public MovieTO getMovieById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieTO> getAllMovies() {
		String sql="select * from movie";
		try(Connection connection=MySQLConnection.getConnection();
			Statement statement=connection.createStatement();			
				
			){
			ResultSet resultSet=statement.executeQuery(sql);
			List<MovieTO> movieList=new ArrayList<>();
			while(resultSet.next()){
				MovieTO movieTO=new MovieTO();
				populateMovieObject(resultSet,movieTO);
				movieList.add(movieTO);
			}
			return movieList;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	private void populateMovieObject(ResultSet resultSet, MovieTO movieTO) throws SQLException {
		movieTO.setMovie_id(resultSet.getInt("movie_id"));
		movieTO.setMovie_name(resultSet.getString("movie_name"));
	}

}
