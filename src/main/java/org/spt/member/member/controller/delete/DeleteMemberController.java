package org.spt.member.member.controller.delete;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.exception.ApiCode;
import org.spt.member.member.usecase.delete.DeleteMemberUseCase;

@RestController
@RequestMapping("member")
public class DeleteMemberController {

    private final DeleteMemberUseCase deleteMemberUseCase;

    public DeleteMemberController(DeleteMemberUseCase deleteMemberUseCase) {
        this.deleteMemberUseCase = deleteMemberUseCase;

    }

    @DeleteMapping("/{pk}")
    public DeleteMemberResponse delete(@PathVariable("pk") Long pk) {
        deleteMemberUseCase.delete(pk);
        return new DeleteMemberResponse(ApiCode.SUCCESS.getCode(), ApiCode.SUCCESS.getMessage());
    }
}
