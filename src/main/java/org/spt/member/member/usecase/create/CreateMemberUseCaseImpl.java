package org.spt.member.member.usecase.create;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.spt.member.member.common.BusinessErrorCode;
import org.spt.member.member.common.BusinessException;
import org.spt.member.member.controller.create.CreateMemberRequest;
import org.spt.member.member.controller.create.CreateMemberResponse;
import org.spt.member.member.exception.ApiException;
import org.spt.member.member.repository.MemberDataService;
import org.spt.member.member.repository.MemberEntity;

import java.util.Optional;

@Service
public class CreateMemberUseCaseImpl implements CreateMemberUseCase {

    private final MemberDataService memberDataService;

    public CreateMemberUseCaseImpl(MemberDataService memberDataService) {
        this.memberDataService = memberDataService;
    }


    @Override
    @Transactional
    public CreateMemberResponse createMember(CreateMemberRequest createMemberRequest) {
        final String email = createMemberRequest.email();
        checkEmail(email);
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(createMemberRequest.email());
        memberEntity.setPassword(createMemberRequest.password());
        memberEntity.setName(createMemberRequest.name());
        memberEntity.setEnable(false);
        memberDataService.create(memberEntity);

        return new CreateMemberResponse();
    }

    /**
     * 檢查電子信箱是否重複
     * @param email
     */
    private void checkEmail(String email) {
        Optional<MemberEntity> byEmailOpt = memberDataService.findByEmail(email);
        if (byEmailOpt.isPresent()) {
            throw new BusinessException(BusinessErrorCode.EMAIL_ERROR);
        }
    }
}
