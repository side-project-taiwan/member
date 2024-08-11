package org.spt.member.member.member.controller.create;


import io.swagger.v3.oas.annotations.media.Schema;

public record Error00002Response(@Schema(name = "code", example = "ERROR00002") String code,
                                 @Schema(name = "message", example = "天氣太冷") String message) {


}
