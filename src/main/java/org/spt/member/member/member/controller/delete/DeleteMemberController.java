package org.spt.member.member.member.controller.delete;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.member.usecase.delete.DeleteMemberUseCase;

@Tag(name = "會員")
@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class DeleteMemberController {

    private final DeleteMemberUseCase deleteMemberUseCase;

    @Operation(summary = "v1刪除會員", description = "呼叫後可以刪除會員")
    @DeleteMapping("/v1/{pk}")
    public DeleteMemberResponse delete(@PathVariable("pk") Long pk) {
        deleteMemberUseCase.delete(pk);
        return new DeleteMemberResponse(pk);
    }
}
