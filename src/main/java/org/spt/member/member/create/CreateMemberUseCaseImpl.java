package org.spt.member.member.create;

import org.springframework.stereotype.Service;
import org.spt.member.member.repository.CreateMemberDataService;
import org.spt.member.member.repository.MemberEntity;

@Service
public class CreateMemberUseCaseImpl implements CreateMemberUseCase {
    private final CreateMemberDataService memberDataService;

    public CreateMemberUseCaseImpl(CreateMemberDataService memberDataService) {
        this.memberDataService = memberDataService;
    }

    @Override
    public CreateMemberResponse createMember(CreateMemberRequest request) {

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEnable(false);
        memberEntity.setPassword(request.password());
        memberEntity.setEmail(request.email());
        memberEntity.setName(request.name());
        memberDataService.create(memberEntity);

        return new CreateMemberResponse();
    }
}
