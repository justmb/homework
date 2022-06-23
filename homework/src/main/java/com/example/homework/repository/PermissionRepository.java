package com.example.homework.repository;

import com.example.homework.entity.Permission;
import com.example.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    List<Permission> findByUser_Name(String username);

    @Query("" +
            "SELECT CASE WHEN COUNT(p) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Permission p " +
            "WHERE p.name = ?1"
    )
    Boolean existPermissionByName(String name);
}
