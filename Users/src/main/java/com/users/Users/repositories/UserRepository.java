package com.users.Users.repositories;

import com.users.Users.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository <UserModel, UUID>{
    boolean existsByName(String name);
    UserDetails findByLogin(String login);
}
