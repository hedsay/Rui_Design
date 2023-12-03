package com.Nreal.BehavioralMode.Observer.event.listener;

import com.Nreal.BehavioralMode.Observer.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MessageEventListener implements EventListener{

    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(Result result) {
        logger.info("给用户 {} 发送短信通知(短信)：{}", result.getUId(), result.getMsg());
    }
}
