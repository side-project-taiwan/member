package org.spt.member.member.common.customexception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
@AllArgsConstructor
public class ValidException extends RuntimeException {
    private BindingResult bindingResult;
}
