package com.nbr.trp.common.controller;

import com.nbr.trp.common.entity.FileResponse;
import com.nbr.trp.common.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*", maxAge = 4800)
@RequestMapping("/api/common")
public class FileController {

    @Autowired
    public FileUploadService fileUploadService;


    @PostMapping("/photo")
    public ResponseEntity<FileResponse> photopost(@RequestPart("file") MultipartFile file) {

        try {
            File f = new ClassPathResource("").getFile();
            final Path path = Paths.get(f.getAbsolutePath() + File.separator + "static" + File.separator + "photo");

            FileResponse fileResponse = fileUploadService.uploadFile(path, file, 0);

            return new ResponseEntity<>(fileResponse, HttpStatus.OK);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/photo/{filename}",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> loadPhoto(@PathVariable String filename) {
        try {
            Path root = Paths.get("target/classes/static/photo");
            System.out.println(root);

            Resource resource = fileUploadService.retrieve(root, filename,0);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentLength(resource.contentLength())
                    .body(resource);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(null);

        }
    }
}
