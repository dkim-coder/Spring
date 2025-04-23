package com.ssafy.ws;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.ws.dao.UserDao;
import com.ssafy.ws.service.UserService;
import com.ssafy.ws.util.DBUtil;

@SpringBootTest
class SpringWsBookApplicationTests {
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










