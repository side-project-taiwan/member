package org.spt.member.member.common.errorcode;

import lombok.Getter;

@Getter
public enum ApiCode {

    SUCCESS("0", "SUCCESS");

    private final String code;
    private final String message;

    ApiCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
