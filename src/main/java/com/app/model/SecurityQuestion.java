package com.app.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="SECURITY_QUESTION")
public class SecurityQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int qId;
    private String question;
    private String answer;

    public SecurityQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
