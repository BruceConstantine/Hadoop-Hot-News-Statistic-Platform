package com.hot.hotshow.mapper;

import com.hot.hotshow.domain.Type0;

import java.util.List;

public interface Type0Mapper {
    int insert(Type0 record);

    int insertSelective(Type0 record);
    List<Type0> selectType0List();
    Long selectSum();
}