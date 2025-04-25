package com.ssafy.ws.dao;

import com.ssafy.ws.dto.Movie;

import java.sql.SQLException;
import java.util.List;


public interface MovieDao {
    //코드를 작성하세요.

    /**
     * Movie 정보 DB 저장
     *
     * @param movie :Movie
     * @return int : row
     * @throws SQLException
     */
    int insert(Movie movie) throws SQLException;

    /**
     * 영화 수정
     *
     * @param movie
     * @return
     * @throws SQLException
     */
    int update(Movie movie) throws SQLException;

    /**
     * 영화 삭제
     *
     * @param id
     * @throws SQLException
     */
    void delete(int id) throws SQLException;

    /**
     * id 도서 검색
     *
     * @param id
     * @return
     * @throws SQLException
     */
    Movie findById(int id) throws SQLException;

    /**
     * 전체 Book 정보를 List로 반환
     *
     * @return books : List<Book>
     * @throws SQLException
     */
    List<Movie> select() throws SQLException;

    int movieCount() throws SQLException;
}