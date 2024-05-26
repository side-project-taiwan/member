package org.spt.member.member.controller.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreateMemberRequest(@Email(message = "email格式錯誤") @NotBlank(message = "不可以空白喔！") String email,
                                  @NotBlank(message = "不可以空白喔！") @Length(min = 3, max = 15) String password,
                                  @NotBlank(message = "不可以空白喔！") String name) {
}
