package com.users.Users.models;

import com.users.Users.enums.TypeUserEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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

    @Column
    private String phone;

    @Column
    private String password;

    @Column(name = "type_user")
    @Enumerated(EnumType.STRING)
    private TypeUserEnum typeUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    Date dateUpdate;

    @PrePersist
    protected void onCreate() {
        dateCreation = new Date();
        dateUpdate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        dateUpdate = new Date();
    }

}
