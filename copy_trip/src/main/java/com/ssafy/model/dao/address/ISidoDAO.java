package com.ssafy.model.dao.address;

import com.ssafy.model.dto.address.Sido;

import java.util.List;

public interface ISidoDAO {
    /**
     * 전체 시도 조회
     *
     * @return
     */
    public List<Sido> getAllSidos();
}
