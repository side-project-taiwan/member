package org.spt.member.member.member.controller.delete;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.member.usecase.delete.DeleteMemberUseCase;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class DeleteMemberController {

    private final DeleteMemberUseCase deleteMemberUseCase;

    @DeleteMapping("/{pk}")
    public DeleteMemberResponse delete(@PathVariable("pk") Long pk) {
        deleteMemberUseCase.delete(pk);
        return new DeleteMemberResponse(pk);
    }
}
