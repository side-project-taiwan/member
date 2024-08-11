package org.spt.member.member.member.controller.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreateMemberRequest(
        @Schema(name = "email", example = "peko@hololive.com", description = "電子信箱") @Email(message = "email格式錯誤") @NotBlank(message = "不可以空白喔！") String email,
        @Schema(name = "password", example = "abc1234567", minLength = 8, maxLength = 78, description = "密碼") @NotBlank(message = "不可以空白喔！") @Length(min = 8, max = 50) String password,
        @Schema(name = "name", example = "usada pekora", description = "暱稱") @Length(min = 3, max = 50) String name) {
}
