package com.edu.eci.ieti.laboratorio.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Document
public class User {
    @Id
    private String id;
    private String name;
    @Indexed (unique = true)
    private String email;
    private String lastname;
    private LocalDate createdAt;

    public User(){
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDate.now();
    }
}
