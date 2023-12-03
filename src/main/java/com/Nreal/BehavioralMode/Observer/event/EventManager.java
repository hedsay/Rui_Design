package com.Nreal.BehavioralMode.Observer.event;

import com.Nreal.BehavioralMode.Observer.Result;
import com.Nreal.BehavioralMode.Observer.event.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    public enum EventType {
        MQ,Message
    }

    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

    public EventManager(Enum<EventType>... operations) {
        for (Enum<EventType> operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> eventListeners = listeners.get(eventType);
        eventListeners.add(listener);
    }
    public void unsubscribe(Enum<EventType> eventType, EventListener listener){
        List<EventListener> eventListeners = listeners.get(eventType);
        eventListeners.remove(listener);
    }
    public void notify(Enum<EventType> eventType, Result result){
        List<EventListener> eventListeners = listeners.get(eventType);
        for (EventListener eventListener : eventListeners) {
            eventListener.doEvent(result);
        }
    }
}
