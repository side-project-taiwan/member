package org.spt.member.member.exception;

import lombok.Getter;

@Getter
public enum ApiCode {

    SUCCESS("0", "SUCCESS");

    private String code;
    private String message;

    ApiCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
