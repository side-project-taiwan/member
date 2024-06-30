package org.spt.member.member.member.controller.createv2;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreateMemberRequestV2(@Email(message = "email格式錯誤") @NotBlank(message = "不可以空白喔！") String email,
                                    @NotBlank(message = "不可以空白喔！") @Length(min = 8, max = 50) String password,
                                    @NotBlank(message = "不可以空白喔！") @Length(min = 3, max = 50) String name) {
}
