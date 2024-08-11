package org.spt.member.member.member.controller.create;


import io.swagger.v3.oas.annotations.media.Schema;

public record Error00003Response(@Schema(name = "code", example = "ERROR00003") String code,
                                 @Schema(name = "message", example = "我的城鎮中心上面有烏鴉在盤旋") String message) {


}
