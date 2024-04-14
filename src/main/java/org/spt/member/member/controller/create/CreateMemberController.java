package org.spt.member.member.controller.create;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class CreateMemberController {

    @PostMapping("/create-member")
    public void createMember(@RequestBody CreateMemberRequest createMemberRequest) {
        System.out.println(createMemberRequest);
    }

}
