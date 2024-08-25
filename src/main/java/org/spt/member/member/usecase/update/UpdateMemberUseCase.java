package org.spt.member.member.usecase.update;

import org.spt.member.member.controller.update.UpdateMemberRequest;
import org.spt.member.member.controller.update.UpdateMemberResponse;

public interface UpdateMemberUseCase {
    UpdateMemberResponse updateMember(UpdateMemberRequest updateMemberRequest);
}
