package com.Nreal.BehavioralMode.chain_of_responsibility;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AuthLink {

    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间格式化

    protected String levelUserId;// 级别人员ID
    protected String levelUserName;// 级别人员姓名
    private AuthLink next;// 责任链

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);

}
