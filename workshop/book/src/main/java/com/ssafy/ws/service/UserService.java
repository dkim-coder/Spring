package com.ssafy.ws.service;

import java.sql.SQLException;

import com.ssafy.ws.dto.User;

public interface UserService {
	public void createUser(User user) throws SQLException;
	public User loginCheck(String email) throws SQLException; 
}
