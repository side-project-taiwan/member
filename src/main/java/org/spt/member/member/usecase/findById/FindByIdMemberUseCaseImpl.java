package org.spt.member.member.usecase.findById;

import org.springframework.stereotype.Service;
import org.spt.member.member.controller.findById.FindByIdMemberRequest;
import org.spt.member.member.controller.findById.FindByIdMemberResponse;
import org.spt.member.member.exception.ApiException;
import org.spt.member.member.repository.MemberDataService;
import org.spt.member.member.repository.MemberEntity;

import java.util.Optional;

@Service
public class FindByIdMemberUseCaseImpl implements FindByIdMemberUseCase {

    private final MemberDataService memberDataService;

    public FindByIdMemberUseCaseImpl(MemberDataService memberDataService) {
        this.memberDataService = memberDataService;
    }

    @Override
    public FindByIdMemberResponse finByIdMember(Long id) {

        Optional<MemberEntity> memberOpt = memberDataService.findByPk(id);

        if(memberOpt.isEmpty()){
            throw new ApiException("can not find member!");
        }
        MemberEntity memberEntity = memberOpt.get();
        return new FindByIdMemberResponse(memberEntity.getEmail(),memberEntity.getPassword(),memberEntity.getName(),memberEntity.getPk());
    }
}
