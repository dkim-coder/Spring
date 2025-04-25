package com.ssafy.ws.repo;

import com.ssafy.ws.dao.UserDao;
import com.ssafy.ws.dto.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class UserDaoImplTest {

    @Autowired
    UserDao dao;

    @Test
    void beanCreate() {
        Assertions.assertNotNull(dao);
    }

    @Test
    void signupTest() throws SQLException {
        User user = User.builder()
                .email("testuser@ssafy.com")
                .password("1234")
                .name("testyser")
                .build();
        dao.createUser(user);

    }

}
