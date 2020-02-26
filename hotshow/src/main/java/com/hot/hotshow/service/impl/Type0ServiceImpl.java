package com.hot.hotshow.service.impl;

import com.hot.hotshow.domain.Type0;
import com.hot.hotshow.mapper.Type0Mapper;
import com.hot.hotshow.service.Type0Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package:
 * @className:
 * @description:
 */
@Service
public class Type0ServiceImpl implements Type0Service{
    @Autowired
    private Type0Mapper type0Mapper;
    @Override
    public List<Type0> selectType0List() {
        return type0Mapper.selectType0List();
    }

    @Override
    public Long selectSum() {
        return type0Mapper.selectSum();
    }
}
