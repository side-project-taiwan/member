package org.spt.member.member.controller.create;

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
public class CreateMemberController {

    private final CreateMemberUseCase createMemberUseCase;

    @PostMapping("/v1/create-member")
    public CreateMemberResponse createMember(@RequestBody @Valid CreateMemberRequest createMemberRequest, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidException(result);
        }
        CreateMemberUseCaseInput input = new CreateMemberUseCaseInput();
        input.setEmail(createMemberRequest.email());
        input.setPassword(createMemberRequest.password());
        input.setName(createMemberRequest.name());

        CreateMemberUseCaseOutput createMemberUseCaseOutput = createMemberUseCase.createMember(input);
        return new CreateMemberResponse(createMemberUseCaseOutput.getPk());
    }
}




