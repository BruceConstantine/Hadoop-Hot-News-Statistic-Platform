package com.hot.hotshow.mapper;

import com.hot.hotshow.domain.Publish;

import java.util.List;

public interface PublishMapper {
    int insert(Publish record);

    int insertSelective(Publish record);
    List<Publish> selectPublishList();
}