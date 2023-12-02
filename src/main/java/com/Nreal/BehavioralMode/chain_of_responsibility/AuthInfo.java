package com.Nreal.BehavioralMode.chain_of_responsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthInfo {

    private String code;
    private String info = "";

    public AuthInfo(String code, String ...infos) {
        this.code = code;
        for (String str:infos){
            this.info = this.info.concat(str);
        }
    }
}
