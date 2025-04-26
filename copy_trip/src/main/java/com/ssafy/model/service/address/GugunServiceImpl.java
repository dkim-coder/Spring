package com.ssafy.model.service.address;

import com.ssafy.model.dao.address.IGugunDAO;
import com.ssafy.model.dto.address.Gugun;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GugunServiceImpl implements IGugunService {
    private final IGugunDAO dao;

    @Override
    public List<Gugun> getAllGuguns() throws SQLException {
        return dao.getAllGuguns();
    }

    public List<Gugun> getGugunsBySidoCode(int sidoCode) {
        return dao.getGugunsBySidoCode(sidoCode);
    }
}
