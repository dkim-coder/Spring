package com.ssafy.model.dao.address;

import com.ssafy.model.dto.address.Gugun;

import java.sql.SQLException;
import java.util.List;

public interface IGugunDAO {

    List<Gugun> getAllGuguns() throws SQLException;

    /**
     * 특정 시도에 속하는 구군 조회
     *
     * @param sidoCode
     * @return
     */
    public List<Gugun> getGugunsBySidoCode(int sidoCode);
}
