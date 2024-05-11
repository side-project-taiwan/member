package org.spt.member.member.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiException extends RuntimeException {
    private String message;
}
