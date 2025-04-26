package com.ssafy.model.service.user;

import com.ssafy.model.dto.user.User;

import java.sql.SQLException;

public interface IUserService {
    public int insert(User user) throws SQLException;

    public Long findNoById(String id) throws SQLException;

    public User findByIdAndPassword(String id, String password) throws SQLException;

    public boolean updatePassword(User user) throws SQLException;

    public boolean updateNickname(User user) throws SQLException;

    public boolean updateImage(User user) throws SQLException;

    public void delete(Long no) throws SQLException;

    public User findByNo(Long no) throws SQLException;

    public String findIdByEmail(String email) throws SQLException;

    public String findPasswordByID(String id) throws SQLException;

    public String makeArgon(String password);

    public boolean checkPassword(String hash, String password);
}
