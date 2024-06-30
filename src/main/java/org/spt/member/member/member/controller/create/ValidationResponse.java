package org.spt.member.member.member.controller.create;

import lombok.Data;

@Data
public class ValidationResponse {
    private String field;
    private String errorMessage;

    public ValidationResponse(String field, String errorMessage) {
        this.field = field;
        this.errorMessage = errorMessage;
    }
}
