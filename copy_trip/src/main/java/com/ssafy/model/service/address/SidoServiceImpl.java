package com.ssafy.model.service.address;

import com.ssafy.model.dao.address.ISidoDAO;
import com.ssafy.model.dto.address.Sido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SidoServiceImpl implements ISidoService {
    private final ISidoDAO dao;

    public List<Sido> getAllSidos() {
        return dao.getAllSidos();
    }
}
