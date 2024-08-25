package org.spt.member.member.controller.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record CreateMemberResponse(@NotNull @Schema(name = "pk", nullable = false, example = "2") Long pk) {
}
