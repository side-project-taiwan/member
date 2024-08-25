package org.spt.member.common.customexception;

import lombok.Getter;
import org.spt.member.common.errorcode.BusinessErrorCode;

@Getter
public class BusinessException extends RuntimeException {

    private final BusinessErrorCode businessErrorCode;


    public BusinessException(BusinessErrorCode businessErrorCode) {
        this.businessErrorCode = businessErrorCode;
    }
}
