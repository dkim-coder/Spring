package com.ssafy.ws.dao;

import java.sql.SQLException;

import com.ssafy.ws.dto.User;

public interface UserDao {
	public void createUser(User user) throws SQLException;
	public User loginCheck(String email) throws SQLException;
}
