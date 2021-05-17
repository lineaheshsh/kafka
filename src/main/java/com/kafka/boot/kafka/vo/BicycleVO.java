package com.kafka.boot.kafka.vo;

import lombok.Data;

@Data
public class BicycleVO {
    private int num;
    private String lcdqr;
    private String qr_cnt;
    private String lcd_cnt;
    private String date;
    private String longitude;
    private String latitude;
    private String detail_addr;
    private String location;
    private String rental_office_nm;
}
