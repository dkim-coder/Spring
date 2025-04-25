package com.ssafy.ws.service;

import com.ssafy.ws.dao.UserDao;
import com.ssafy.ws.dto.User;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao dao;

    @Override
    public void createUser(User user) throws SQLException {
        //password 암호화
        user.setPassword(BCrypt.hashpw(user.getPassword().trim(), BCrypt.gensalt()));
        dao.createUser(user);

    }

    @Override
    public User loginCheck(String email) throws SQLException {

        return dao.loginCheck(email);
    }

}
