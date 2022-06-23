package com.example.homework.repository;

import com.example.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserPermission_Name(String permissionName);

    @Query("" +
            "SELECT CASE WHEN COUNT(u) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM User u " +
            "WHERE u.email = ?1"
    )
    boolean existUserByEmail (String email);
}