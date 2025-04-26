package com.ssafy.model.service.address;

import com.ssafy.model.dto.address.Gugun;

import java.sql.SQLException;
import java.util.List;

public interface IGugunService {
    List<Gugun> getAllGuguns() throws SQLException;

    public List<Gugun> getGugunsBySidoCode(int sidoCode);
}
