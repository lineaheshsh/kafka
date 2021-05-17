package com.kafka.boot.kafka.dao;

import com.kafka.boot.kafka.mapper.BicycleMapper;
import com.kafka.boot.kafka.vo.BicycleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BicycleDao {

    @Autowired
    BicycleMapper bicycleMapper;

    /**
     * 공영 자전거 정보(queue message) 입력
     * @param bicycleVO
     */
    public void insertBicycle(BicycleVO bicycleVO) {
        bicycleMapper.insertBicycle(bicycleVO);
    }
}
