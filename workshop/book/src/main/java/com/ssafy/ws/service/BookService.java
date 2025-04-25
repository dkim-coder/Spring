package com.ssafy.ws.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.dto.Book;

public interface BookService {
	
	/**
	 * Book 정보 DB 저장
	 * @param book :Book
	 * @throws SQLException
	 */
	void insert(Book book) throws SQLException;
	/**
	 * 도서정보 수정
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	void update(Book book) throws SQLException;
	
	/**
	 * 도서 삭제
	 * @param isbn
	 * @throws SQLException
	 */
	void delete(String isbn) throws SQLException;
	
	/**
	 * isbn 도서 검색
	 * @param isbn
	 * @return
	 * @throws SQLException
	 */
	Book findByIsbn(String isbn) throws SQLException;
	
	/**
	 *  전체 Book 정보를 List로 반환
	 * @return books : List<Book>
	 * @throws SQLException
	 */
	List<Book> select() throws SQLException;
}
