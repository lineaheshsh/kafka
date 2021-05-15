package com.kafka.boot.kafka.vo;

import lombok.Data;

@Data
public class NewsVO {
    private String contents_id;
    private String domain;
    private String category_nm;
    private String title;
    private String contents;
    private String writer;
    private String date;
    private String ampm;
    private String time;
    private String company;
    private String udt_dt;
    private String url;
}
