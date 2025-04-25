package com.ssafy.ws.repo;

import com.ssafy.ws.dao.BookDao;
import com.ssafy.ws.dto.Book;
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
class BookDaoImplTest {
    @Autowired
    BookDao dao;

    @Test
    void beanCreate() {
        Assertions.assertNotNull(dao);
    }

    @BeforeEach
    public void insert() throws SQLException {
        Book book = Book.builder()
                .isbn("test1111")
                .author("ssafy")
                .title("javatest")
                .price(1000)
                .desc("mybatis test")
                .build();
        dao.insert(book);
    }


    @Test
    public void update() throws SQLException {
        Book book = dao.findByIsbn("test1111");
        book.setTitle("updatetest");
        dao.update(book);
        book = dao.findByIsbn("test1111");
        Assertions.assertEquals(book.getTitle(), "updatetest");
    }

    @Test
    public void delete() throws SQLException {
        Book book = dao.findByIsbn("test1111");
        book.setTitle("updatetest");
        dao.delete("test1111");
        book = dao.findByIsbn("test1111");
        Assertions.assertNull(book);
    }

    @Test
    public void selectAll() throws SQLException {

        List<Book> books = dao.select();
        Assertions.assertNotEquals(books.size(), 0);
    }
}
