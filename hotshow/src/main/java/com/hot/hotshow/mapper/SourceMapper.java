package com.hot.hotshow.mapper;

import com.hot.hotshow.domain.Source;

import java.util.List;

public interface SourceMapper {
    int insert(Source record);

    int insertSelective(Source record);
    List<Source> selectSourceTop10();
}