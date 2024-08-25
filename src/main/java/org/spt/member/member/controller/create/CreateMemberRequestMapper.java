package org.spt.member.member.controller.create;

import org.spt.member.member.usecase.create.CreateMemberUseCaseInput;

public class CreateMemberRequestMapper {
    static CreateMemberUseCaseInput map(CreateMemberRequest createMemberRequest) {
        CreateMemberUseCaseInput createMemberUseCaseInput = new CreateMemberUseCaseInput();
        createMemberUseCaseInput.setEmail(createMemberRequest.email());
        createMemberUseCaseInput.setPassword(createMemberRequest.password());
        createMemberUseCaseInput.setName(createMemberRequest.name());
        return createMemberUseCaseInput;
    }

}
