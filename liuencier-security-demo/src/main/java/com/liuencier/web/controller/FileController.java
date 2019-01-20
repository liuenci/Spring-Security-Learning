package com.liuencier.web.controller;

import com.liuencier.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

    @GetMapping("{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (
                InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outputStream = response.getOutputStream();
        ) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=1.jpg");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }
    }
}
