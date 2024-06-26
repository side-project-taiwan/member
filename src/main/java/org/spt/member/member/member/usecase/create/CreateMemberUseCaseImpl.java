package org.spt.member.member.member.usecase.create;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.spt.member.member.common.customexception.BusinessException;
import org.spt.member.member.common.errorcode.BusinessErrorCode;
import org.spt.member.member.member.repository.MemberDao;
import org.spt.member.member.member.repository.MemberEntity;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateMemberUseCaseImpl implements CreateMemberUseCase {

    private final MemberDao memberDao;

    @Override
    @Transactional
    public CreateMemberUseCaseOutput createMember(CreateMemberUseCaseInput createMemberUseCaseInput) {
        final String email = createMemberUseCaseInput.getEmail();
        checkEmail(email);
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(createMemberUseCaseInput.getEmail());
        memberEntity.setPassword(createMemberUseCaseInput.getPassword());
        memberEntity.setName(createMemberUseCaseInput.getName());
        memberEntity.setEnable(false);
        MemberEntity createdEntity = memberDao.create(memberEntity);
        CreateMemberUseCaseOutput output = new CreateMemberUseCaseOutput();
        output.setPk(createdEntity.getPk());
        output.setEmail(createdEntity.getEmail());
        output.setName(createdEntity.getName());
        return output;
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
