package org.spt.member.member.controller.findById;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.member.usecase.findById.FindByIdMemberUseCase;

@Tag(name = "會員")
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class FindByIdMemberController {
    private final FindByIdMemberUseCase findByIdMemberUseCase;

    @Operation(summary = "v1查詢單一會員", description = "呼叫後可以查詢單一會員")
    @GetMapping("/v1/find-by-pk/{pk}")
    public ResponseEntity<?> findByPk(@PathVariable("pk") long pk) {
        log.info("[FindByMemberController][findByPk][request pk = {}]", pk);
        return ResponseEntity.ok(findByIdMemberUseCase.finByPk(pk));
    }
}
