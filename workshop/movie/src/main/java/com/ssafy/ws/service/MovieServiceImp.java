package com.ssafy.ws.service;

import com.ssafy.ws.dao.MovieDao;
import com.ssafy.ws.dto.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImp implements MovieService {
    private final MovieDao dao;

    @Override
    public int insert(Movie movie) throws SQLException {
        // TODO Auto-generated method stub
        return dao.insert(movie);
    }

    @Override
    public int update(Movie movie) throws SQLException {
        // TODO Auto-generated method stub
        return dao.update(movie);
    }

    @Override
    public void delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        dao.delete(id);
    }

    @Override
    public Movie findById(int id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public List<Movie> select() throws SQLException {
        return dao.select();
    }

    @Override
    public int getMovieCount() throws SQLException {
        return dao.movieCount();
    }

}
