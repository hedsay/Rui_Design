package com.Nreal.BehavioralMode.Observer;

import java.util.Date;

public class ServiceImpl extends Service{

    private Lottery l = new Lottery();

    @Override
    protected Result doDraw(String uid) {
        String res = l.lottery(uid);
        return new Result(uid,res,new Date());
    }
}
