package com.kafka.boot.kafka.service;

import com.kafka.boot.kafka.dto.BicycleDto;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class BicycleService {

    public void process(String message) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObj = (JSONObject) parser.parse(message);
            if (jsonObj.containsKey("payload")) {
                JSONObject payloadObj = (JSONObject) jsonObj.get("payload");

                if (payloadObj != null) {

                    // bicycle Json 포맷 Dto로 변경(build 패턴)
                    BicycleDto bicycleDto = BicycleDto.builder().num(Integer.parseInt(payloadObj.get("num").toString()))
                                                                .location(payloadObj.get("location").toString())
                                                                .detail_addr(payloadObj.get("detail_addr").toString())
                                                                .rental_office_nm(payloadObj.get("rental_office_nm").toString())
                                                                .date(payloadObj.get("date").toString())
                                                                .latitude(payloadObj.get("latitude").toString())
                                                                .longitude(payloadObj.get("longitude").toString())
                                                                .lcd_cnt(payloadObj.get("lcd_cnt").toString())
                                                                .qr_cnt(payloadObj.get("qr_cnt").toString())
                                                                .lcdqr(payloadObj.get("lcdqr").toString())
                                                                .build();

                    System.out.println("bicycleDto :: " + bicycleDto);


                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
