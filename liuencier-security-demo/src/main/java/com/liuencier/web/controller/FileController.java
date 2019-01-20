package com.liuencier.web.controller;

import com.liuencier.dto.FileInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "C:\\user\\projects\\IdeaProjects\\Spring-Security\\liuencier-security-demo\\src\\main\\java\\com\\liuencier\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println("===== FileName: " + file.getName());
        System.out.println("===== OriginalFilename: " + file.getOriginalFilename());
        System.out.println("===== FileSize: " + file.getSize());

        File localFile = new File(folder, new Date().getTime() + ".txt");

        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }
}
