package org.spt.member.member.controller.create;

import org.spt.member.member.usecase.create.CreateMemberUseCaseOutput;

public class CreateMemberResponseMapper {

    static CreateMemberResponse map(CreateMemberUseCaseOutput createMemberUseCaseOutput) {
        return new CreateMemberResponse(createMemberUseCaseOutput.getPk());
    }

}
