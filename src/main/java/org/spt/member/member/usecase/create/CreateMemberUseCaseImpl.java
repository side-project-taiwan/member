package org.spt.member.member.usecase.create;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.spt.member.member.common.BusinessErrorCode;
import org.spt.member.member.common.BusinessException;
import org.spt.member.member.controller.create.CreateMemberRequest;
import org.spt.member.member.controller.create.CreateMemberResponse;
import org.spt.member.member.repository.MemberDao;
import org.spt.member.member.repository.MemberEntity;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateMemberUseCaseImpl implements CreateMemberUseCase {

    private final MemberDao memberDao;

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
        MemberEntity createdEntity = memberDao.create(memberEntity);

        return new CreateMemberResponse(createdEntity.getPk());
    }

    /**
     * 檢查電子信箱是否重複
     */
    private void checkEmail(String email) {
        Optional<MemberEntity> byEmailOpt = memberDao.findByEmail(email);
        if (byEmailOpt.isPresent()) {
            throw new BusinessException(BusinessErrorCode.EMAIL_ERROR);
        }
    }
}
