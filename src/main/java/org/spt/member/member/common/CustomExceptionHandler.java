package org.spt.member.member.common;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.spt.member.member.common.customexception.BusinessException;
import org.spt.member.member.common.customexception.ValidException;
import org.spt.member.member.common.exceptionresponse.ApiErrorResponse;
import org.spt.member.member.common.exceptionresponse.ValidErrorResponse;
import org.spt.member.member.common.exceptionresponse.ValidationResponse;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptionResponse(final Exception e) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse("400", "未知的錯誤");
        return ResponseEntity.badRequest().body(apiErrorResponse);
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessExceptionResponse(final BusinessException e) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(e.getBusinessErrorCode().getCode(), e.getBusinessErrorCode().getMessage());
        return ResponseEntity.badRequest().body(apiErrorResponse);
    }

    @ExceptionHandler(ValidException.class)
    public ResponseEntity<?> handleValidExceptionResponse(final ValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        List<ValidationResponse> validationResponses = new ArrayList<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            validationResponses.add(new ValidationResponse(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        ValidErrorResponse validErrorResponse = new ValidErrorResponse();
        validErrorResponse.setCode("888");
        validErrorResponse.setMessage("驗證參數錯誤");
        validErrorResponse.setValidationResponseList(validationResponses);
        return ResponseEntity.badRequest().body(validErrorResponse);
    }

}
