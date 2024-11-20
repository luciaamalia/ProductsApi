package com.users.Users.models;

import com.users.Users.enums.TypeUserEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.List;
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


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER")); //controle de perfis
    }

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
