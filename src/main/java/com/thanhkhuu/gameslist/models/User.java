package com.thanhkhuu.gameslist.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=10, message = "Username must be between 3-10 characters long.")
    private String username;

    @Email(message = "Email must be a valid email address")
    private String email;

    @NotNull
    @Size(min=8, message = "Password must be 8 characters or more.")
    private String password;

    @NotNull(message = "Passwords gotta match!")
    private String verify;

    public User (String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private void checkPass() {
        if (password != null && verify != null && !password.equals(verify)) {
            verify = null;
        }
    }

    public User() {}

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
        checkPass();
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
        checkPass();
    }
}
