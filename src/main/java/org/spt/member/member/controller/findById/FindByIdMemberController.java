package org.spt.member.member.controller.findById;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.exception.ApiErrorResponse;
import org.spt.member.member.exception.ApiException;
import org.spt.member.member.usecase.findById.FindByIdMemberUseCase;

@RestController
@RequestMapping("/member")
public class FindByIdMemberController {
    private final FindByIdMemberUseCase findByIdMemberUseCase;

    public FindByIdMemberController(FindByIdMemberUseCase findByIdMemberUseCase) {
        this.findByIdMemberUseCase = findByIdMemberUseCase;
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> findByIdMember(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(findByIdMemberUseCase.finByIdMember(id));
        } catch (ApiException e) {
            return ResponseEntity.badRequest().body(new ApiErrorResponse("a123",e.getMessage()));
        }
    }
}
