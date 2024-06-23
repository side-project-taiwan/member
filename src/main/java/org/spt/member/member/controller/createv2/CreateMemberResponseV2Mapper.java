package org.spt.member.member.controller.createv2;

import org.spt.member.member.usecase.create.CreateMemberUseCaseOutput;

public class CreateMemberResponseV2Mapper {
    static CreateMemberResponseV2 map(CreateMemberUseCaseOutput createMemberUseCaseOutput) {
        return new CreateMemberResponseV2(createMemberUseCaseOutput.getPk(), createMemberUseCaseOutput.getEmail(), createMemberUseCaseOutput.getName());
    }
}
