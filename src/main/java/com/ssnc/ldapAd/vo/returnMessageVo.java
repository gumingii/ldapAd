package com.ssnc.ldapAd.vo;

import lombok.Data;

@Data
public class returnMessageVo {
	private String status;  // status code
	private String error;   // error
    private String message; // 메시지
    private String errorclass;
    private Exception oe;
}