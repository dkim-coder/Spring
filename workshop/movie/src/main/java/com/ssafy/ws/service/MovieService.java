package com.ssafy.ws.service;

import com.ssafy.ws.dto.Movie;

import java.sql.SQLException;
import java.util.List;

public interface MovieService {

    int insert(Movie movie) throws SQLException;

    int update(Movie movie) throws SQLException;

    void delete(int id) throws SQLException;

    Movie findById(int id) throws SQLException;

    List<Movie> select() throws SQLException;

    int getMovieCount() throws SQLException;
}
