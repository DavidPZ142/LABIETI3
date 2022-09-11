package com.edu.eci.ieti.laboratorio.entity;

import com.edu.eci.ieti.laboratorio.DTO.options.RoleEnum;
import com.edu.eci.ieti.laboratorio.DTO.UserDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class User {
    @Id
    private String id;
    private String name;
    @Indexed (unique = true)
    private String email;
    private String lastname;
    private LocalDate createdAt;
    private String passwordHash;
    private List<RoleEnum> roles;

    public User(UserDto userDto) {
        this.id = UUID.randomUUID().toString();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.lastname = userDto.getLastname();
        this.createdAt = LocalDate.now();
        this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        roles = new ArrayList<>();
        roles.add(RoleEnum.USER);
    }


}
