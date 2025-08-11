package com.example.demo;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String filename;

    @Lob
    private byte[] content;

    private LocalDateTime uploadTime;

    private LocalDateTime expirationTime;

    private String uuid;
}