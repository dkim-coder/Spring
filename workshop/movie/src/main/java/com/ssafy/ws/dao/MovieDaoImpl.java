package com.ssafy.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.dto.Movie;
import com.ssafy.ws.util.DBUtil;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl implements MovieDao {
	private final DBUtil util;

	public MovieDaoImpl(DBUtil util)
	{
		this.util = util;
	}

	@Override
	public List<Movie> selectAllMovies() throws SQLException {
		List<Movie> movies = new ArrayList<>();
		Connection con = util.getConnection();
		String sql = new StringBuilder(" SELECT id, title, director, genre, runningTime\n")
				.append("FROM movie")
				.toString();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();

		while (result.next()) {
			movies.add(new Movie(result.getInt("id"), result.getString("title"), result.getString("director"),
					result.getString("genre"), result.getInt("runningTime")));
		}

		util.close(con, stmt, result);

		return movies;
	}

	@Override
	public boolean insertMovie(Movie movie) throws SQLException {
		if (movie == null)
			return false;

		List<Movie> movies = selectAllMovies();
		for (Movie m : movies)
			if (m.getId() == movie.getId())
				return false;

		String sql = new StringBuilder("INSERT INTO movie (id, title, director, genre, runningTime) \n")
				.append("VALUES(?,?,?,?,?)")
				.toString();
		Connection con = util.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		int index = 1;
		stmt.setInt(index++, movie.getId());
		stmt.setString(index++, movie.getTitle());
		stmt.setString(index++, movie.getDirector());
		stmt.setString(index++, movie.getGenre());
		stmt.setInt(index++, movie.getRunningTime());

		stmt.executeUpdate();

		util.close(stmt, con);

		return true;
	}

	@Override
	public int movieCount() throws SQLException {
		return selectAllMovies().size();
	}

}
