package com.example.demo.controller;

import com.example.demo.FileEntity;
import com.example.demo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @PostMapping("/upload")
    @Transactional
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam(value = "expirationMinutes", required = false) Integer expirationMinutes)
            throws Exception {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFilename(file.getOriginalFilename());
        fileEntity.setContent(file.getBytes());
        fileEntity.setUploadTime(LocalDateTime.now());
        fileEntity.setUuid(UUID.randomUUID().toString());

        if (expirationMinutes != null) {
            fileEntity.setExpirationTime(LocalDateTime.now().plusMinutes(expirationMinutes));
        }

        fileRepository.save(fileEntity);
        return "/download/" + fileEntity.getUuid();
    }

    @GetMapping("/download/{uuid}")
    @Transactional
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String uuid) {
        FileEntity fileEntity = fileRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("File not found"));

        if (fileEntity.getExpirationTime() != null &&
                fileEntity.getExpirationTime().isBefore(LocalDateTime.now())) {
            fileRepository.delete(fileEntity);
            throw new RuntimeException("File expired");
        }

        ByteArrayResource resource = new ByteArrayResource(fileEntity.getContent());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileEntity.getFilename())
                .body(resource);
    }
}