package com.app.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER_DB")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String email;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="qId")
    private SecurityQuestion securityQuestion;

    public User(String username, String email, String password, SecurityQuestion question) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.securityQuestion = question;
    }
}
