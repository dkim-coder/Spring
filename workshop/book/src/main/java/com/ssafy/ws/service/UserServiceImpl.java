package com.ssafy.ws.service;

import com.ssafy.ws.dao.UserDao;
import com.ssafy.ws.dto.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {
    UserDao dao;

    public UserServiceImpl(UserDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public void createUser(User user) throws SQLException {
        //password 암호화
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        dao.createUser(user);

    }

    @Override
    public User loginCheck(String email) throws SQLException {

        return dao.loginCheck(email);
    }

}
