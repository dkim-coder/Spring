package com.ssafy.model.dao.attraction;

import com.ssafy.model.dto.attraction.ContentType;

import java.util.List;

public interface IContentTypeDAO {
    /**
     * 전체 콘텐츠타입 조회
     *
     * @return
     */
    public List<ContentType> getAllContentTypes();
}
