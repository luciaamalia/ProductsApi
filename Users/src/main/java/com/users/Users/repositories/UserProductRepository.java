package com.users.Users.repositories;

import com.users.Users.models.UserProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserProductRepository extends JpaRepository<UserProductModel, UUID> {
}