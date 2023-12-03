package com.Nreal.BehavioralMode.Observer.event.listener;

import com.Nreal.BehavioralMode.Observer.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MQEventListener implements EventListener{
    private Logger logger = LoggerFactory.getLogger(MQEventListener.class);
    @Override
    public void doEvent(Result result) {
        logger.info("记录用户 {} 摇号结果(MQ)：{}", result.getUId(), result.getMsg());
    }
}
