package org.spt.member.member.member.usecase.delete;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.spt.member.member.common.customexception.BusinessException;
import org.spt.member.member.common.errorcode.BusinessErrorCode;
import org.spt.member.member.member.controller.delete.DeleteMemberResponse;
import org.spt.member.member.member.repository.MemberDao;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteMemberUseCaseImpl implements DeleteMemberUseCase {
    private final MemberDao memberDao;

    @Override
    public DeleteMemberResponse delete(Long pk) {
        try {
            memberDao.delete(pk);
        } catch (Exception e) {
            log.error("[DeleteMemberUseCaseImpl][delete][request pk = {}]", pk);
            throw new BusinessException(BusinessErrorCode.DATABASE_ERROR);
        }
        return new DeleteMemberResponse(pk);
    }
}
