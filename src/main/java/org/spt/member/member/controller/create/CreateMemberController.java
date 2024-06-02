package org.spt.member.member.controller.create;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.common.ValidException;
import org.spt.member.member.usecase.create.CreateMemberUseCase;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class CreateMemberController {

    private final CreateMemberUseCase createMemberUseCase;

    @PostMapping("/create-member")
    public ResponseEntity<?> createMember(@RequestBody @Valid CreateMemberRequest createMemberRequest, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidException(result);
        }
        return ResponseEntity.ok(createMemberUseCase.createMember(createMemberRequest));
    }
}




