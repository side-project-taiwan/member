package org.spt.member.member.member.usecase.delete;

import org.spt.member.member.member.controller.delete.DeleteMemberResponse;

public interface DeleteMemberUseCase {
    DeleteMemberResponse delete(Long pk);
}
