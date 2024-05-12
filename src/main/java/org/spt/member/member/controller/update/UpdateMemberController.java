package org.spt.member.member.controller.update;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.spt.member.member.exception.ApiErrorResponse;
import org.spt.member.member.exception.ApiException;
import org.spt.member.member.usecase.update.UpdateMemberUseCase;

@RestController
@RequestMapping("/member")
public class UpdateMemberController {
    private final UpdateMemberUseCase updateMemberUseCase;

    public UpdateMemberController(UpdateMemberUseCase updateMemberUseCase) {
        this.updateMemberUseCase = updateMemberUseCase;
    }


    @PutMapping("/update")
    public ResponseEntity<?> updateByIdMember(@RequestBody UpdateMemberRequest updateMemberRequest) {
        try {
            return ResponseEntity.ok(updateMemberUseCase.updateMember(updateMemberRequest));
        } catch (ApiException e) {
            return ResponseEntity.badRequest().body(new ApiErrorResponse("a456",e.getMessage()));
        }
    }
}
