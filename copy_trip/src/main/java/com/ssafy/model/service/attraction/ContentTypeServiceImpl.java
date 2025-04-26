package com.ssafy.model.service.attraction;

import com.ssafy.model.dao.attraction.IContentTypeDAO;
import com.ssafy.model.dto.attraction.ContentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentTypeServiceImpl implements IContentTypeService {

    private final IContentTypeDAO dao;

    public List<ContentType> getAllContentTypes() {
        return dao.getAllContentTypes();
    }
}
