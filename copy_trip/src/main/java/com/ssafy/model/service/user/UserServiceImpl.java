package com.ssafy.model.service.user;

import com.ssafy.model.dao.user.IUserDAO;
import com.ssafy.model.dto.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserDAO dao;

    public int insert(User user) throws SQLException {
        return dao.insert(user);
    }

    public Long findNoById(String id) throws SQLException {
        return dao.findNoById(id);
    }

    public User findByIdAndPassword(String id, String password) throws SQLException {
        return dao.findByIdAndPassword(id, password);
    }

    public boolean updatePassword(User user) throws SQLException {
        return dao.updatePassword(user);
    }

    public boolean updateNickname(User user) throws SQLException {
        return dao.updateNickname(user);
    }

    public boolean updateImage(User user) throws SQLException {
        return dao.updateImage(user);
    }

    public void delete(Long no) throws SQLException {
        dao.delete(no);
    }

    public User findByNo(Long no) throws SQLException {
        return dao.findByNo(no);
    }

    public String findIdByEmail(String email) throws SQLException {
        return dao.findIdByEmail(email);
    }

    public String findPasswordByID(String id) throws SQLException {
        return dao.findPasswordByID(id);
    }

    @Override
    public String makeArgon(String password) {
        return dao.makeArgon(password);
    }

    @Override
    public boolean checkPassword(String hash, String password) {
        return dao.checkPassword(hash, password);
    }
}
