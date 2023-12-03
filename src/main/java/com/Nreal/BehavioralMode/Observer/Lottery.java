package com.Nreal.BehavioralMode.Observer;


import java.time.LocalDate;
import java.util.Date;

public class Lottery {
    public String lottery(String uId) {
        Date date = new Date();
        return Math.abs(date.hashCode()) % 2 == 0 ? "恭喜你，编码".concat(uId).concat("在本次摇号中签") : "很遗憾，编码".concat(uId).concat("在本次摇号未中签或摇号资格已过期");
    }
}
