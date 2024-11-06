package com.users.Users.models;

import com.users.Users.enums.TypeUserEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "users")
@Table(name = "users")
public class UserModel {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUser;

    @Column
    private String name;

    @Column
    @Email
    private String email;

    @Column(name = "type_user")
    @Enumerated(EnumType.STRING)
    private TypeUserEnum typeUser;

}
