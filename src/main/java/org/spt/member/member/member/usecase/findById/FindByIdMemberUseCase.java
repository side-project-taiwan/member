package org.spt.member.member.member.usecase.findById;

import org.spt.member.member.member.controller.findById.FindByIdMemberResponse;

public interface FindByIdMemberUseCase {
    FindByIdMemberResponse finByPk(Long id);

}
