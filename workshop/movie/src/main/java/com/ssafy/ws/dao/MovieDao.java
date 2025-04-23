package com.ssafy.ws.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.dto.Movie;

public interface MovieDao {

	List<Movie> selectAllMovies() throws SQLException;

	boolean insertMovie(Movie movie) throws SQLException;

	int movieCount() throws SQLException;
}