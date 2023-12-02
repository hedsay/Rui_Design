package com.Nreal.BehavioralMode.chain_of_responsibility;

import com.Nreal.BehavioralMode.chain_of_responsibility.impl.L1;
import com.Nreal.BehavioralMode.chain_of_responsibility.impl.L2;
import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.util.Date;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class test {
    public static void main(String[] args) throws ParseException {
        AuthLink authLink = new L2("1002","主任")
                .appendNext(new L1("1001","锐总"));

        AuthService.auth("1002","10001");
        log.println("二级审批，主任");
        log.println(JSON.toJSONString(authLink.doAuth("rui","10001",new Date())));

        AuthService.auth("1001","10001");
        log.println("一级审批，锐总");
        log.println(JSON.toJSONString(authLink.doAuth("rui","10001",new Date())));
    }
}
