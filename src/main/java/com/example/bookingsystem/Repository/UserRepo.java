package com.example.bookingsystem.Repository;

import com.example.bookingsystem.Entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo  extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
    Optional<UserEntity> findById(Long id);
    void deleteById(Long id);
    UserEntity save (UserEntity userEntity);  /// this to save user in database

}
