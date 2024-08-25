package org.spt.member.member.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "檔案")
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {


    @PostMapping("/v1")
    public void upLoadFile(MultipartFile file) {

    }
}
