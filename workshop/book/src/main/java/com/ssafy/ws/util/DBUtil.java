package com.ssafy.ws.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DBUtil {
    private final String DRIVER_CLASSNAME = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
    private final String USER = "ssafy";
    private final String PASSWORD = "ssafy";
 
    public DBUtil() {
        try {
            Class.forName(DRIVER_CLASSNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
//        Properties props = new Properties();
//        props.setProperty("user", USER);
//        props.setProperty("password", PASSWORD);
//        props.setProperty("profileSQL", "true");  // 쿼리 프로파일링 활성화

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

   
    public void close(AutoCloseable... closeables) {
        for (AutoCloseable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception ignore) {

                }
            }
        }
    }
}
