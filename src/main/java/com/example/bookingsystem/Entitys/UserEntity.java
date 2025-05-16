package com.example.bookingsystem.Entitys;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
/// we use Serializable to make the class serializabl and trnsfer the class atribute to byte to we cant sed it over the network vie sestion
@Entity
public class UserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // this is primary key

    private String username;
    @Column(unique = true  ) // this is to make email unique
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role; // USER or ADMIN

    public UserEntity(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
