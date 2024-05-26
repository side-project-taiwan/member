package org.spt.member.member.controller.create;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.common.BusinessErrorCode;
import org.spt.member.member.common.BusinessException;
import org.spt.member.member.common.ValidException;
import org.spt.member.member.usecase.create.CreateMemberUseCase;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member")
public class CreateMemberController {

    private final CreateMemberUseCase createMemberUseCase;

    public CreateMemberController(CreateMemberUseCase createMemberUseCase) {
        this.createMemberUseCase = createMemberUseCase;
    }

    @PostMapping("/create-member")
    public ResponseEntity<?> createMember(@RequestBody @Valid CreateMemberRequest createMemberRequest, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidException(result);
        }
        return ResponseEntity.ok(createMemberUseCase.createMember(createMemberRequest));
    }
}
