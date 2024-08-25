package org.spt.member.member.usecase.findById;

import org.spt.member.member.controller.findById.FindByIdMemberResponse;

public interface FindByIdMemberUseCase {
    FindByIdMemberResponse finByPk(Long id);

}
