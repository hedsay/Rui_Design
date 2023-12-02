package com.Nreal.BehavioralMode.chain_of_responsibility.impl;

import com.Nreal.BehavioralMode.chain_of_responsibility.AuthInfo;
import com.Nreal.BehavioralMode.chain_of_responsibility.AuthLink;
import com.Nreal.BehavioralMode.chain_of_responsibility.AuthService;

import java.util.Date;

public class L1 extends AuthLink {

    public L1(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId,orderId);
        if(null == date){
            return new AuthInfo("单号：",orderId,"状态：待一级审批负责人",levelUserName);
        }
        AuthLink next = super.next();
        if(null == next){
            return new AuthInfo("单号：",orderId,"状态：一级审批完成负责人",levelUserName,"时间：",f.format(date));
        }
        return next.doAuth(uId,orderId,authDate);
    }
}
