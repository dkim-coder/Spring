package com.ssafy.ws.dao;

import com.ssafy.ws.dto.User;

import java.sql.SQLException;

public interface UserDao {
    public void createUser(User user) throws SQLException;

    public User loginCheck(String email) throws SQLException;
}
