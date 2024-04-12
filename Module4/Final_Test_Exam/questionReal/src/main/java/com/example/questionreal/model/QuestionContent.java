package com.example.questionreal.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String answer;
    private Date dateCreate;
    private boolean status;
    @ManyToOne
    @JoinColumn
    private QuestionType idQuestionType;
    public QuestionContent(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public QuestionType getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(QuestionType idQuestionType) {
        this.idQuestionType = idQuestionType;
    }
}
