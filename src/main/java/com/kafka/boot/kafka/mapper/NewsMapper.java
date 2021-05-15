package com.kafka.boot.kafka.mapper;

import com.kafka.boot.kafka.vo.NewsVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {

    @Select("SELECT * FROM VIEW_NEWS ORDER BY CONTENTS_ID ASC")
    List<NewsVO> findNews();

    @Insert("INSERT INTO TB_NEWS_KAFKA(contents_id, category, title, contents, writer, date, ampm, time, company, udt_dt, url) VALUES(#{contents_id}, #{category_nm}, #{title}, #{contents}, #{writer}, #{date}, #{ampm}, #{time}, #{company}, #{udt_dt}, #{url})")
    void insertNews(NewsVO newsVO);
}
