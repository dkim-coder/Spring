package com.ssafy.ws.service;

import com.ssafy.ws.dao.BookDao;
import com.ssafy.ws.dto.Book;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao dao;

    public BookServiceImpl(BookDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public void insert(Book book) throws SQLException {
        dao.insert(book);
    }

    @Override
    public void update(Book book) throws SQLException {
        dao.update(book);
    }

    @Override
    public void delete(String isbn) throws SQLException {
        dao.delete(isbn);

    }

    @Override
    public Book findByIsbn(String isbn) throws SQLException {
        return dao.findByIsbn(isbn);
    }

    @Override
    public List<Book> select() throws SQLException {
        return dao.select();
    }

}
