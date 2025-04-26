package com.ssafy.model.dao.user;

import com.ssafy.model.dto.user.User;

import java.sql.SQLException;

public interface IUserDAO {

    /**
     * user 정보를 db에 저장한다
     */
    int insert(User user) throws SQLException;

    /**
     * 유저 id값으로 배열의 no 값 가져오기
     */
    Long findNoById(String id) throws SQLException;

    User findByIdAndPassword(String id, String password) throws SQLException;

    /**
     * 비밀번호 재설정
     */
    boolean updatePassword(User user) throws SQLException;

    /**
     * 닉네임 재설정
     */
    boolean updateNickname(User user) throws SQLException;

    /**
     * 사용자 이미지 재설정
     */
    boolean updateImage(User user) throws SQLException;

    /**
     * 회원 탈퇴
     */
    void delete(Long no) throws SQLException;

    /**
     * user의 no를 통해서 유저 정보 가져오기
     */
    User findByNo(Long no) throws SQLException;

    /**
     * 이메일 정보를 통해서 유저 id 정보 가져오기
     */
    String findIdByEmail(String email) throws SQLException;

    /**
     * 유저 id 정보를 통해서 유저 비밀번호 가져오기
     */
    String findPasswordByID(String id) throws SQLException;

    String makeArgon(String string);

    boolean checkPassword(String hash, String password);
}
