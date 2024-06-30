package org.spt.member.member.member.usecase.create;

import lombok.Data;

@Data
public class CreateMemberUseCaseOutput {
    private Long pk;
    private String email;
    private String name;
}
