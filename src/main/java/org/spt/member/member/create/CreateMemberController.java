package org.spt.member.member.create;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class CreateMemberController {

    private final CreateMemberUseCase createMemberUseCase;

    public CreateMemberController(CreateMemberUseCase createMemberUseCase) {
        this.createMemberUseCase = createMemberUseCase;
    }


    @PostMapping("/create-member")
    public CreateMemberResponse createMember(@RequestBody CreateMemberRequest createMemberRequest) {
        return createMemberUseCase.createMember(createMemberRequest);
    }

}
