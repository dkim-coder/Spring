package com.ssafy.ws.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ws.dao.BookDao;
import com.ssafy.ws.dao.BookDaoImpl;
import com.ssafy.ws.dto.Book;

@Service
public class BookServiceImpl implements BookService {
	private BookDao dao;
	
	public BookServiceImpl(BookDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int insert(Book book) throws SQLException {
		// TODO Auto-generated method stub
		return dao.insert(book);
	}

	@Override
	public int update(Book book) throws SQLException {
		// TODO Auto-generated method stub
		return dao.update(book);
	}

	@Override
	public void delete(String isbn) throws SQLException {
		dao.delete(isbn);

	}

	@Override
	public Book findByIsbn(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		return dao.findByIsbn(isbn);
	}

	@Override
	public List<Book> select() throws SQLException {
		// TODO Auto-generated method stub
		return dao.select();
	}

}
