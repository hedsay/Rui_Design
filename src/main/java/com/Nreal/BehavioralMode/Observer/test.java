package com.Nreal.BehavioralMode.Observer;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class test {
    private Logger logger = LoggerFactory.getLogger(test.class);

    public static void main(String[] args) {
        Service service = new ServiceImpl();
        Result result = service.draw("0001");
        log.println(JSON.toJSONString(result));
    }
}
