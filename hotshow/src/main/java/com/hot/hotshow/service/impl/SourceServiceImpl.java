package com.hot.hotshow.service.impl;

import com.hot.hotshow.domain.Source;
import com.hot.hotshow.mapper.SourceMapper;
import com.hot.hotshow.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package:
 * @className:
 * @description:
 */
@Service
public class SourceServiceImpl implements SourceService{
    @Autowired
    private SourceMapper sourceMapper;
    @Override
    public List<Source> selectSourceTop10() {
        return sourceMapper.selectSourceTop10();
    }
}
