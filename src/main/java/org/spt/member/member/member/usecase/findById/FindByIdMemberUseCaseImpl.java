package org.spt.member.member.member.usecase.findById;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.spt.member.member.common.customexception.BusinessException;
import org.spt.member.member.common.errorcode.BusinessErrorCode;
import org.spt.member.member.member.controller.findById.FindByIdMemberResponse;
import org.spt.member.member.member.repository.MemberDao;
import org.spt.member.member.member.repository.MemberEntity;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindByIdMemberUseCaseImpl implements FindByIdMemberUseCase {

    private final MemberDao memberDao;


    @Override
    public FindByIdMemberResponse finByPk(Long id) {

        Optional<MemberEntity> memberOpt = memberDao.findByPk(id);

        if (memberOpt.isEmpty()) {
            throw new BusinessException(BusinessErrorCode.DATA_NOT_FOUND);
        }
        MemberEntity memberEntity = memberOpt.get();
        return new FindByIdMemberResponse(memberEntity.getEmail(), memberEntity.getName(), memberEntity.getPk());
    }
}
