package org.spt.member.member.member.controller.createv2;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.common.customexception.ValidException;
import org.spt.member.member.member.usecase.create.CreateMemberUseCase;
import org.spt.member.member.member.usecase.create.CreateMemberUseCaseInput;
import org.spt.member.member.member.usecase.create.CreateMemberUseCaseOutput;

@Tag(name = "會員")
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class CreateMemberControllerV2 {

    private final CreateMemberUseCase createMemberUseCase;

    @Operation(summary = "v2新增會員", description = "呼叫後可以新增會員")
    @PostMapping("/v2")
    public CreateMemberResponseV2 createMember(@RequestBody @Valid CreateMemberRequestV2 createMemberRequestV2, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidException(result);
        }
        CreateMemberUseCaseInput createMemberUseCaseInput = CreateMemberRequestV2Mapper.map(createMemberRequestV2);
        CreateMemberUseCaseOutput createMemberUseCaseOutput = createMemberUseCase.createMember(createMemberUseCaseInput);
        return CreateMemberResponseV2Mapper.map(createMemberUseCaseOutput);
    }

}




