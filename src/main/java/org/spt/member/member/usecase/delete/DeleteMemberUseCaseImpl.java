package org.spt.member.member.usecase.delete;

import org.springframework.stereotype.Service;
import org.spt.member.member.controller.delete.DeleteMemberResponse;
import org.spt.member.member.repository.MemberDataService;

@Service
public class DeleteMemberUseCaseImpl implements DeleteMemberUseCase {
    private final MemberDataService memberDataService;

    public DeleteMemberUseCaseImpl(MemberDataService memberDataService) {
        this.memberDataService = memberDataService;
    }

    @Override
    public DeleteMemberResponse delete(Long pk) {
        memberDataService.delete(pk);
        return new DeleteMemberResponse();
    }
}
