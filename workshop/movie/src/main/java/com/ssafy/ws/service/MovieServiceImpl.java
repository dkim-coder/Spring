package com.ssafy.ws.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.dao.MovieDao;
import com.ssafy.ws.dao.MovieDaoImpl;
import com.ssafy.ws.dto.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{
	MovieDao dao;

	public MovieServiceImpl(MovieDao dao)
	{
		this.dao = dao;
	}

	@Override
	public List<Movie> selectAllMovies() throws SQLException {
		return dao.selectAllMovies();
	}

	@Override
	public boolean insertMovie(Movie movie) throws SQLException {
		return dao.insertMovie(movie);
	}

	@Override
	public int movieCount() throws SQLException {
		return dao.movieCount();
	}
	
}
