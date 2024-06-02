package org.spt.member.member.controller.findById;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.usecase.findById.FindByIdMemberUseCase;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class FindByIdMemberController {
    private final FindByIdMemberUseCase findByIdMemberUseCase;


    @GetMapping("/find-by-pk/{pk}")
    public ResponseEntity<?> findByPk(@PathVariable("pk") long pk) {
        log.info("[FindByMemberController][findByPk][request pk = {}]", pk);
        return ResponseEntity.ok(findByIdMemberUseCase.finByPk(pk));
    }
}
