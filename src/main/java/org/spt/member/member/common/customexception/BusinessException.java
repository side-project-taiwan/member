package org.spt.member.member.common.customexception;

import lombok.Getter;
import org.spt.member.member.common.errorcode.BusinessErrorCode;

@Getter
public class BusinessException extends RuntimeException {

    private final BusinessErrorCode businessErrorCode;


    public BusinessException(BusinessErrorCode businessErrorCode) {
        this.businessErrorCode = businessErrorCode;
    }
}
