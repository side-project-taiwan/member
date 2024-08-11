package org.spt.member.member.member.controller.create;


import io.swagger.v3.oas.annotations.media.Schema;

public record Error00001Response(@Schema(name = "code", example = "ERROR00001") String code,
                                 @Schema(name = "message", example = "不合法的參數") String message) {


}
