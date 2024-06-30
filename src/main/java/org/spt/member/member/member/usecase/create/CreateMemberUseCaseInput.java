package org.spt.member.member.member.usecase.create;

import lombok.Data;

@Data
public class CreateMemberUseCaseInput {
    private String email;
    private String password;
    private String name;
}
