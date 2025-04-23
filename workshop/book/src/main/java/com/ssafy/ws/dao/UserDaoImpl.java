package com.ssafy.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.util.DBUtil;

/**
 * UserDaoImpl은 stateless하므로 Singleton으로 작성한다.
 */
@Repository
public class UserDaoImpl implements UserDao{

	private DBUtil db;
	
	public UserDaoImpl(DBUtil db) {
		this.db=db;
	}
	
	@Override
	public void createUser(User user) throws SQLException {
		Connection con= db.getConnection();
		String sql=new StringBuilder("INSERT INTO user (id, name, pass) \n")
								.append("VALUES (?,?,?)")
								.toString();
				
		PreparedStatement stmt=con.prepareStatement(sql);
		int index=1;
		stmt.setString(index++,  user.getEmail());
		stmt.setString(index++, user.getName());
		stmt.setString(index++, user.getPassword());

		stmt.executeUpdate();
		
		db.close(stmt, con);
	}

	@Override
	public User loginCheck(String email) throws SQLException {
		User user=null;
		Connection con = db.getConnection();
		String sql = new StringBuilder("SELECT id, name, pass \n")
									.append("FROM user \n")
									.append("WHERE id =?")
									.toString();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet result = null;
		
		stmt.setString(1, email);
		result = stmt.executeQuery();
		
		if(result.next()) {
			user = new User(result.getString(1 ), 
									result.getString(2),
									result.getString(3));
		}
		
		db.close(result, stmt, con);
		
		return user;
	}
	
	
}
