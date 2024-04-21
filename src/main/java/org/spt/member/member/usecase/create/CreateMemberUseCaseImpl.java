package org.spt.member.member.usecase.create;

import org.springframework.stereotype.Service;
import org.spt.member.member.controller.create.CreateMemberRequest;
import org.spt.member.member.controller.create.CreateMemberResponse;
import org.spt.member.member.repository.MemberDataService;
import org.spt.member.member.repository.MemberEntity;

@Service
public class CreateMemberUseCaseImpl implements CreateMemberUseCase {

    private final MemberDataService memberDataService;

    public CreateMemberUseCaseImpl(MemberDataService memberDataService) {
        this.memberDataService = memberDataService;
    }


    @Override
    public CreateMemberResponse createMember(CreateMemberRequest createMemberRequest) {

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(createMemberRequest.email());
        memberEntity.setPassword(createMemberRequest.password());
        memberEntity.setName(createMemberRequest.name());
        memberEntity.setEnable(false);
        memberDataService.create(memberEntity);

        return new CreateMemberResponse();
    }
}
