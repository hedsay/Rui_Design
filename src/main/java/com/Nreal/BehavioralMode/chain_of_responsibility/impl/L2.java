package com.Nreal.BehavioralMode.chain_of_responsibility.impl;

import com.Nreal.BehavioralMode.chain_of_responsibility.AuthInfo;
import com.Nreal.BehavioralMode.chain_of_responsibility.AuthLink;
import com.Nreal.BehavioralMode.chain_of_responsibility.AuthService;

import java.text.ParseException;
import java.util.Date;

public class L2 extends AuthLink {

    private Date beginDate = f.parse("2023-12-01 00:00:00");
    private Date endDate = f.parse("2023-12-05 23:59:59");

    public L2(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId,orderId);
        if(null == date){
            return new AuthInfo("单号：",orderId,"状态：待二级审批负责人",levelUserName);
        }
        AuthLink next = super.next();
        if(null == next){
            return new AuthInfo("单号：",orderId,"状态：二级审批完成负责人",levelUserName,"时间：",f.format(date));
        }
        if(authDate.before(beginDate) || authDate.after(endDate)){
            return new AuthInfo("单号：",orderId,"状态：二级审批完成负责人",levelUserName,"时间：",f.format(date));
        }
        return next.doAuth(uId,orderId,authDate);
    }
}
