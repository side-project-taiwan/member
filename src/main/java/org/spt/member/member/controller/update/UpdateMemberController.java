package org.spt.member.member.controller.update;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.usecase.update.UpdateMemberUseCase;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class UpdateMemberController {
    private final UpdateMemberUseCase updateMemberUseCase;

    @PutMapping("/update")
    public ResponseEntity<?> updateByIdMember(@RequestBody UpdateMemberRequest updateMemberRequest) {
            return ResponseEntity.ok(updateMemberUseCase.updateMember(updateMemberRequest));
    }
}
