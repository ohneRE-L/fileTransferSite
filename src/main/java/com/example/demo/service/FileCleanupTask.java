package com.example.demo.service;

import com.example.demo.FileEntity;
import com.example.demo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Component
public class FileCleanupTask {

    @Autowired
    private FileRepository fileRepository;

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void cleanExpiredFiles() {
        fileRepository.findAll().stream()
                .filter(file -> file.getExpirationTime() != null &&
                        file.getExpirationTime().isBefore(LocalDateTime.now()))
                .forEach(fileRepository::delete);
    }
}