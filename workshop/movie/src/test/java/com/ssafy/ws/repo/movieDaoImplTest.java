package com.ssafy.ws.repo;

import com.ssafy.ws.dao.MovieDao;
import com.ssafy.ws.dto.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Transactional
class movieDaoImplTest {
	@Autowired
	MovieDao dao;

	@Test
	void beanCreate() {
		Assertions.assertNotNull(dao);
	}
	
	@BeforeEach
	public void insert() throws SQLException {
		Movie movie = new Movie(102, "test", "test", "test", 120);
		dao.insert(movie);
	}

	@Test
	public void update() throws SQLException {
		Movie movie = dao.findById(1);
		movie.setTitle("updatetest");
		dao.update(movie);
		movie = dao.findById(1);
	    Assertions.assertEquals(movie.getTitle(), "updatetest");
	}
	
	@Test
	public void delete() throws SQLException {
		Movie movie = dao.findById(1);
		movie.setTitle("updatetest");
		dao.delete(1);
		movie = dao.findById(1);
	    Assertions.assertNull(movie);
	}	
		
	@Test
	public void selectAll() throws SQLException {
		List<Movie> movies = dao.select();
	    Assertions.assertNotEquals(movies.size(), 0);
	}	
}
