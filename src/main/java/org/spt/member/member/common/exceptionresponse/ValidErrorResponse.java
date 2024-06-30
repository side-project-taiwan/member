package org.spt.member.member.common.exceptionresponse;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ValidErrorResponse {
    private String code;
    private String message;
    private List<ValidationResponse> validationResponseList;
}
