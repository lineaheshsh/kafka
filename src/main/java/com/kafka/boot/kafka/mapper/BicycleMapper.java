package com.kafka.boot.kafka.mapper;

import com.kafka.boot.kafka.vo.BicycleVO;
import com.kafka.boot.kafka.vo.NewsVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BicycleMapper {

    @Insert("INSERT INTO bicycle_rental_office_info(num, rental_office_nm, location, detail_addr, latitude, longitude, date, lcd_cnt, qr_cnt, lcdqr) VALUES(#{num}, #{rental_office_nm}, #{location}, #{detail_addr}, #{latitude}, #{longitude}, #{date}, #{lcd_cnt}, #{qr_cnt}, #{lcdqr})")
    void insertBicycle(BicycleVO bicycleVO);
}
