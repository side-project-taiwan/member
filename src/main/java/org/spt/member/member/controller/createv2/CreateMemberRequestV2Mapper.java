package org.spt.member.member.controller.createv2;

import org.spt.member.member.usecase.create.CreateMemberUseCaseInput;

public class CreateMemberRequestV2Mapper {
    static CreateMemberUseCaseInput map(CreateMemberRequestV2 createMemberRequestV2) {
        CreateMemberUseCaseInput input = new CreateMemberUseCaseInput();
        input.setEmail(createMemberRequestV2.email());
        input.setPassword(createMemberRequestV2.password());
        input.setName(createMemberRequestV2.name());
        return input;
    }
}
