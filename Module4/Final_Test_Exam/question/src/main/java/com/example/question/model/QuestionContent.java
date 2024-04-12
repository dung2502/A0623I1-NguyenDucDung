package com.example.question.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.sql.Date;

@Entity
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @NotNull(message = "Khong duoc de trong")
//    @Size(min = 5,max = 100,message = "Tiêu đề phải từ 5 đến 100 ký tự ")
    private String title;
//    @NotNull(message = "Khong duoc de trong")
//    @Size(min = 5,max = 100,message = "Tiêu đề phải từ 10 đến 500 ký tự ")
    private String content;
    private String answer;
    //    @NotNull(message = "Khong duoc de trong")
    private Date date_create;
    private Boolean status;
    @ManyToOne
    @JoinColumn
    private QuestionType id_question_type;

    public QuestionContent() {
    }

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

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public QuestionType getId_question_type() {
        return id_question_type;
    }

    public void setId_question_type(QuestionType id_question_type) {
        this.id_question_type = id_question_type;
    }
}
