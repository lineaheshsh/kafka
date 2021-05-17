package com.kafka.boot.kafka.service;

import com.kafka.boot.kafka.dao.BicycleDao;
import com.kafka.boot.kafka.vo.BicycleVO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BicycleService {

    @Autowired
    private BicycleDao bicycleDao;

    /**
     * 공영 자전거 처리 로직
     * @param message
     */
    public void process(String message) {

        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObj = (JSONObject) parser.parse(message);
            if (jsonObj.containsKey("payload")) {
                JSONObject payloadObj = (JSONObject) jsonObj.get("payload");

                if (payloadObj != null) {

                    BicycleVO bicycleVO = new BicycleVO();
                    bicycleVO.setNum(Integer.parseInt(payloadObj.get("num").toString()));
                    bicycleVO.setLocation(payloadObj.get("location").toString());
                    bicycleVO.setDetail_addr(payloadObj.get("detail_addr").toString());
                    bicycleVO.setRental_office_nm(payloadObj.get("rental_office_nm").toString());
                    bicycleVO.setDate(payloadObj.get("date").toString());
                    bicycleVO.setLatitude(payloadObj.get("latitude").toString());
                    bicycleVO.setLongitude(payloadObj.get("longitude").toString());
                    bicycleVO.setLcd_cnt(payloadObj.get("lcd_cnt").toString());
                    bicycleVO.setQr_cnt(payloadObj.get("qr_cnt").toString());
                    bicycleVO.setLcdqr(payloadObj.get("lcdqr").toString());

                    System.out.println("bicycleVO :: " + bicycleVO);

                    bicycleDao.insertBicycle(bicycleVO);
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
