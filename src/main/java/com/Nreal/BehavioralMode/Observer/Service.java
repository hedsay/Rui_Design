package com.Nreal.BehavioralMode.Observer;

import com.Nreal.BehavioralMode.Observer.event.EventManager;
import com.Nreal.BehavioralMode.Observer.event.listener.MQEventListener;
import com.Nreal.BehavioralMode.Observer.event.listener.MessageEventListener;

public abstract class Service {
    private EventManager eventManager;

    public Service() {
        eventManager = new EventManager(EventManager.EventType.MQ,EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ,new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message,new MessageEventListener());
    }

    public Result draw(String uid){
        Result result = doDraw(uid);
        eventManager.notify(EventManager.EventType.MQ,result);
        eventManager.notify(EventManager.EventType.Message,result);
        return result;
    }

    protected abstract Result doDraw(String uid);

}
