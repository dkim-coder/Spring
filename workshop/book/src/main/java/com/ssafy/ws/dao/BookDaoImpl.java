package com.ssafy.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.util.DBUtil;

/**
 * BookDaoImpl은 stateless하므로 Singleton으로 작성한다.
 */
@Repository
public class BookDaoImpl implements BookDao{
	private DBUtil db;
	
	public BookDaoImpl(DBUtil db) {
		this.db = db;
	}

	@Override
	public int insert(Book book) throws SQLException {
//		if( isExist(book.getIsbn()) ) throw new DuplicationException(); 
		//Driver load -> connection -> query실행 -> 결과처리 ->close
		String sql = new StringBuilder("INSERT INTO book (isbn, title, author, price, `desc`) \n")
										.append("VALUES(?, ?, ?,?,?)")
										.toString();
		Connection con = db.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		int index=1;
		stmt.setString(index++, book.getIsbn());
		stmt.setString(index++, book.getTitle());
		stmt.setString(index++, book.getAuthor());
		stmt.setInt(index++, book.getPrice());
		stmt.setString(index++, book.getDesc());
		
		int row = stmt.executeUpdate();
		
		db.close(stmt, con);
		
		return row;
	}

	@Override
	public List<Book> select() throws SQLException {
		List<Book> books = new ArrayList<>();
		Connection con = db.getConnection();
		String sql = new StringBuilder(" SELECT isbn, title, author, price, `desc`\n")
										.append("FROM book")
										.toString();
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		ResultSet result = stmt.executeQuery();
		while(result.next()) {
			books.add(new Book(result.getString("isbn"),
										 result.getString("title"),
										 result.getString("author"),
										 result.getInt("price"),
										 result.getString("desc")
								  )
					      );
		}
		
		db.close(con, stmt, result);
		return books;
	}

	@Override
	public int update(Book book) throws SQLException {
		String sql = new StringBuilder("UPDATE book \n")
									  .append("SET title=?, author=?, price=?, `desc`=? \n")
									  .append("WHERE isbn=?")
									  .toString();
		Connection con = db.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		int index=1;
		stmt.setString(index++, book.getTitle());
		stmt.setString(index++, book.getAuthor());
		stmt.setInt(index++, book.getPrice());
		stmt.setString(index++, book.getDesc());
		stmt.setString(index++, book.getIsbn());

		int row = stmt.executeUpdate();
		
		db.close(stmt, con);
		
		return row;
	}

	@Override
	public void delete(String isbn) throws SQLException {
		Connection con = db.getConnection();
		String sql = new StringBuilder(" DELETE FROM book \n")
										.append("WHERE isbn=?")
										.toString();
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, isbn);
		
		stmt.executeUpdate();
	
		db.close(con, stmt);

		
	}

	@Override
	public Book findByIsbn(String isbn) throws SQLException {
		Book book = null;
		Connection con = db.getConnection();
		String sql = new StringBuilder(" SELECT isbn, title, author, price, `desc`\n")
										.append("FROM book \n")
										.append("WHERE isbn=?")
										.toString();
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, isbn);
		
		ResultSet result = stmt.executeQuery();
		if(result.next()) {
			book =new Book(result.getString("isbn"),
										 result.getString("title"),
										 result.getString("author"),
										 result.getInt("price"),
										 result.getString("desc")
									);
		}
		
		db.close(con, stmt, result);
		return book;
	}

	
}


