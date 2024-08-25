package org.spt.member.member.controller.create;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spt.member.common.customexception.ValidException;
import org.spt.member.member.usecase.create.CreateMemberUseCase;
import org.spt.member.member.usecase.create.CreateMemberUseCaseInput;
import org.spt.member.member.usecase.create.CreateMemberUseCaseOutput;

@Tag(name = "會員")
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class CreateMemberController {

    private final CreateMemberUseCase createMemberUseCase;

    @Operation(summary = "v1新增會員", description = "呼叫後可以新增會員")
    @PostMapping("/v1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "A00000", description = "Ok", content =
                    {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = CreateMemberResponse.class))}),
            @ApiResponse(responseCode = "ERROR00001", content =
                    {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = Error00001Response.class))}),
            @ApiResponse(responseCode = "ERROR00002", content =
                    {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = Error00002Response.class))}),
            @ApiResponse(responseCode = "ERROR00003", content =
                    {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = Error00003Response.class))}),
            @ApiResponse(responseCode = "ERROR00004", content =
                    {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = ErrorResponse.class))})})
    public CreateMemberResponse createMember(@RequestBody @Valid CreateMemberRequest createMemberRequest, BindingResult result) {
        log.info("[CreateMemberController][createMember][createMemberRequest = {}]", createMemberRequest);
        if (result.hasErrors()) {
            throw new ValidException(result);
        }
        CreateMemberUseCaseInput createMemberUseCaseInput = CreateMemberRequestMapper.map(createMemberRequest);
        CreateMemberUseCaseOutput createMemberUseCaseOutput = createMemberUseCase.createMember(createMemberUseCaseInput);
        return CreateMemberResponseMapper.map(createMemberUseCaseOutput);
    }


}




