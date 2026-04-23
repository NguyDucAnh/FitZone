package com.fitzone.fitzone.repository;

import com.fitzone.fitzone.entity.UserEntity;
import com.fitzone.fitzone.enums.StatusEnum;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    List<UserEntity> findByStatus(StatusEnum status);
    boolean existsByIdAndStatus(Long id, StatusEnum status);
    boolean existsByUsernameAndStatus(String username, StatusEnum status);
    UserEntity findByUsernameAndStatus(String username, StatusEnum status);
    UserEntity findByIdAndStatus(Long userId, StatusEnum status);
}