package org.spt.member.common.errorcode;

import lombok.Getter;

@Getter
public enum BusinessErrorCode {
    WRONG_PASSWORD("A0001", "password error"),
    WRONG_ACCOUNT("A0002", "account error"),
    WRONG_EMAIL("A0003", "email error"),
    EMAIL_ERROR("A0004", "duplicate email address"),
    DATA_NOT_FOUND("D0001", "data not found"),
    DATABASE_ERROR("D0000", "database error+");


    private final String message;
    private final String code;

    BusinessErrorCode(String code, String message) {
        this.message = message;
        this.code = code;
    }


}
