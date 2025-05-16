package com.example.bookingsystem.Service;

import com.example.bookingsystem.Entitys.UserEntity;
import com.example.bookingsystem.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

@Service
public class UserService  {

    /// this is make register and login for user
    @Autowired
    private UserRepo userRepo;   /// this is to connect with database via userRepo interface
    /// / this is used to autonticate user (when user login)
    public UserEntity FindUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    public void registerUser(UserEntity user) {
        userRepo.save(user);
    }
}
