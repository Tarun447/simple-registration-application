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
    @Column(unique = true)
    private String username;
    private String password;
    private String answer;
    private int qId;


    public User(String username, String password,int qId,String answer) {
        this.username = username;
        this.password = password;
        this.qId = qId;
        this.answer=answer;
    }
}
