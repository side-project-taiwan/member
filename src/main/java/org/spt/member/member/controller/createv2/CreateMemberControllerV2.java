package org.spt.member.member.controller.createv2;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.common.ValidException;
import org.spt.member.member.usecase.create.CreateMemberUseCase;
import org.spt.member.member.usecase.create.CreateMemberUseCaseInput;
import org.spt.member.member.usecase.create.CreateMemberUseCaseOutput;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class CreateMemberControllerV2 {

    private final CreateMemberUseCase createMemberUseCase;

    @PostMapping("/v2")
    public CreateMemberResponseV2 createMember(@RequestBody @Valid CreateMemberRequestV2 createMemberRequestV2, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidException(result);
        }
        CreateMemberUseCaseInput input = new CreateMemberUseCaseInput();
        input.setEmail(createMemberRequestV2.email());
        input.setPassword(createMemberRequestV2.password());
        input.setName(createMemberRequestV2.name());

        CreateMemberUseCaseOutput createMemberUseCaseOutput = createMemberUseCase.createMember(input);
        return new CreateMemberResponseV2(createMemberUseCaseOutput.getPk(), createMemberUseCaseOutput.getEmail(), createMemberUseCaseOutput.getName());
    }
}




