package com.om.UserService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="user_service")
public class User {
    @Id
    private String userId;
    private String name;
    private String email;
    private String about;
}
