package com.Nreal.BehavioralMode.Observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Result {
    private String uId;//用户
    private String msg;//摇号信息
    private Date dateTime;
}
