package org.spt.member.member.controller.createv2;

import jakarta.validation.constraints.NotNull;

public record CreateMemberResponseV2(@NotNull Long pk, String email, String name) {
}
