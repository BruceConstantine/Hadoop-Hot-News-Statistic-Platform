package com.hot.hotshow.service.impl;

import com.hot.hotshow.domain.Publish;
import com.hot.hotshow.mapper.PublishMapper;
import com.hot.hotshow.service.PublishSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package:
 * @className:
 * @description:
 */
@Service
public class PublishServiceImpl implements PublishSevice{
    @Autowired
    private PublishMapper publishMapper;
    @Override
    public List<Publish> selectPublishList() {
        return publishMapper.selectPublishList();
    }
}
