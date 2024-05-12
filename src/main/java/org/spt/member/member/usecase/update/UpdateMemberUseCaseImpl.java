package org.spt.member.member.usecase.update;

import org.springframework.stereotype.Service;
import org.spt.member.member.controller.update.UpdateMemberRequest;
import org.spt.member.member.controller.update.UpdateMemberResponse;
import org.spt.member.member.exception.ApiException;
import org.spt.member.member.repository.MemberDataService;
import org.spt.member.member.repository.MemberEntity;

import java.util.Optional;

@Service
public class UpdateMemberUseCaseImpl implements UpdateMemberUseCase {
    private final MemberDataService memberDataService;

    public UpdateMemberUseCaseImpl(MemberDataService memberDataService) {
        this.memberDataService = memberDataService;
    }

    @Override
    public UpdateMemberResponse updateMember(UpdateMemberRequest updateMemberRequest) {
        Long pk = updateMemberRequest.pk();
        Optional<MemberEntity> memberEntityOpt = memberDataService.findByPk(pk);

        if(memberEntityOpt.isEmpty()){
            throw new ApiException("can not find member!");
        }

        MemberEntity memberEntity = memberEntityOpt.get();
        memberEntity.setName(updateMemberRequest.name());
        MemberEntity updateMemberEntity = memberDataService.update(memberEntity);

        return new UpdateMemberResponse(updateMemberEntity.getPk(),updateMemberEntity.getName(),updateMemberEntity.getEmail());

    }
}
