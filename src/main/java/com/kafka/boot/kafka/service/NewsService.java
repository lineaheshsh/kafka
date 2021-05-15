package com.kafka.boot.kafka.service;

import com.kafka.boot.kafka.mapper.NewsMapper;
import com.kafka.boot.kafka.vo.NewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Transactional
    public void insertNews(NewsVO newsVO) {

        if ( newsVO != null ) {
            newsMapper.insertNews(newsVO);
        }
    }
}
