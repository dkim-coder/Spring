package com.ssafy.ws.service;

import com.ssafy.ws.dto.User;

import java.sql.SQLException;

public interface UserService {
    public void createUser(User user) throws SQLException;

    public User loginCheck(String email) throws SQLException;
}
