package org.spt.member.member.common;

import lombok.Getter;

@Getter
public enum BusinessErrorCode {
    WRONG_PASSWORD("A0001", "密碼錯誤"),
    WRONG_ACCOUNT("A0002", "帳號錯誤"),
    WRONG_EMAIL("A0003", "電子信箱錯誤"),
    EMAIL_ERROR("A0004", "電子信箱不可重複"),
    DATA_NOT_FOUND("D0001", "資料不存在"),
    DATABASE_ERROR("D0000", "資料庫操作失敗");


    BusinessErrorCode(String code, String message) {
        this.message = message;
        this.code = code;
    }

    private final String message;
    private final String code;


}
