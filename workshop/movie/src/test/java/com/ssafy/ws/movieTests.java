package com.ssafy.ws;

import com.ssafy.ws.dao.UserDao;
import com.ssafy.ws.service.UserService;
import com.ssafy.ws.util.DBUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class movieTests {

    @Autowired
    DBUtil db;

    @Autowired
    UserDao dao;

    @Autowired
    UserService service;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(db);
        Assertions.assertNotNull(dao);
        Assertions.assertNotNull(service);
    }

}
