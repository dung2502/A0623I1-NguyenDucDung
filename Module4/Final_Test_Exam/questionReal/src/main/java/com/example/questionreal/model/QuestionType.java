package com.example.questionreal.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "idQuestionType")
    private List<QuestionContent> questionContents;

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

    public List<QuestionContent> getQuestionContents() {
        return questionContents;
    }

    public void setQuestionContents(List<QuestionContent> questionContents) {
        this.questionContents = questionContents;
    }
}
