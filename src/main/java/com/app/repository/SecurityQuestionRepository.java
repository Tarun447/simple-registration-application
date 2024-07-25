package com.app.repository;

import com.app.model.SecurityQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SecurityQuestionRepository extends JpaRepository <SecurityQuestion,Integer>{

    public SecurityQuestion findByQuestion(String question) throws Exception;
}
