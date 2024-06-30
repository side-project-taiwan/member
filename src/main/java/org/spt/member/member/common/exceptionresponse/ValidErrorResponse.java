package org.spt.member.member.common.exceptionresponse;

import lombok.*;
import org.spt.member.member.member.controller.create.ValidationResponse;

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
