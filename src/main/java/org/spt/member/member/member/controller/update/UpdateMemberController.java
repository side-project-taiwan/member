package org.spt.member.member.member.controller.update;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.member.usecase.update.UpdateMemberUseCase;

@Tag(name = "會員")
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class UpdateMemberController {
    private final UpdateMemberUseCase updateMemberUseCase;

    @Operation(summary = "v1更新單一會員", description = "呼叫後可以更新單一會員")
    @PutMapping("/v1")
    public ResponseEntity<?> updateByIdMember(@RequestBody UpdateMemberRequest updateMemberRequest) {
        return ResponseEntity.ok(updateMemberUseCase.updateMember(updateMemberRequest));
    }
}
