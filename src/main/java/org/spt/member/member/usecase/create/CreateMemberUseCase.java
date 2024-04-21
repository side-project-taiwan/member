package org.spt.member.member.usecase.create;

import org.spt.member.member.controller.create.CreateMemberRequest;
import org.spt.member.member.controller.create.CreateMemberResponse;

public interface CreateMemberUseCase {
    CreateMemberResponse createMember(CreateMemberRequest createMemberRequest);
}
