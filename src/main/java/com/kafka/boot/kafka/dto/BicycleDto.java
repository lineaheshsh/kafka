package com.kafka.boot.kafka.dto;


import lombok.*;

@Getter
@NoArgsConstructor
@ToString
public class BicycleDto {
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

    @Builder
    public BicycleDto(int num, String lcdqr, String qr_cnt, String lcd_cnt, String date
            , String longitude, String latitude, String detail_addr, String location, String rental_office_nm) {
        this.num = num;
        this.lcdqr = lcdqr;
        this.qr_cnt = qr_cnt;
        this.lcd_cnt = lcd_cnt;
        this.date = date;
        this.longitude = longitude;
        this.latitude = latitude;
        this.detail_addr = detail_addr;
        this.location = location;
        this.rental_office_nm = rental_office_nm;
    }
}
