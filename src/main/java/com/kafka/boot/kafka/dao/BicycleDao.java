package com.kafka.boot.kafka.dao;

import com.kafka.boot.kafka.vo.BicycleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BicycleDao {

    /**
     * 공영 자전거 정보(queue message) 입력
     * @param bicycleVO
     */
    void insertBicycle(BicycleVO bicycleVO);
}
