package com.example.question.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "id_question_type")
    private List<QuestionContent> questionContents;

    public List<QuestionContent> getQuestionContents() {
        return questionContents;
    }

    public void setQuestionContents(List<QuestionContent> questionContents) {
        this.questionContents = questionContents;
    }

    public QuestionType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
