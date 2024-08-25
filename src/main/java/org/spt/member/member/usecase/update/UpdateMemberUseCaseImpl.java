package org.spt.member.member.usecase.update;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.spt.member.common.customexception.BusinessException;
import org.spt.member.common.errorcode.BusinessErrorCode;
import org.spt.member.member.controller.update.UpdateMemberRequest;
import org.spt.member.member.controller.update.UpdateMemberResponse;
import org.spt.member.member.repository.MemberDao;
import org.spt.member.member.repository.MemberEntity;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateMemberUseCaseImpl implements UpdateMemberUseCase {
    private final MemberDao memberDao;

    @Override
    public UpdateMemberResponse updateMember(UpdateMemberRequest updateMemberRequest) {
        Long pk = updateMemberRequest.pk();
        Optional<MemberEntity> memberEntityOpt = memberDao.findByPk(pk);

        if (memberEntityOpt.isEmpty()) {
            throw new BusinessException(BusinessErrorCode.DATA_NOT_FOUND);
        }

        MemberEntity memberEntity = memberEntityOpt.get();
        memberEntity.setName(updateMemberRequest.name());
        MemberEntity updateMemberEntity = memberDao.update(memberEntity);

        return new UpdateMemberResponse(updateMemberEntity.getPk(), updateMemberEntity.getName(), updateMemberEntity.getEmail());

    }
}
