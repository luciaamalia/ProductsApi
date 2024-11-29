package com.users.Users.models;

import com.users.Users.dtos.ResponseProductsDTO;
import com.users.Users.enums.TypeUserEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "users")
@Table(name = "users")
public class UserModel implements UserDetails {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUser;

    @Column
    private String name;

    @Column
    private String login;

    @Column
    private String phone;

    @Email
    @Column
    private String email;

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


    @Override
    public String getUsername() {return login;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }


    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
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
