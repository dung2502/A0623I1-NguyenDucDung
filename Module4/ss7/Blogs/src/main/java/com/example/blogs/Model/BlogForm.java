package com.example.blogs.Model;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Long id;
    private String user;
    private Category category;
    private String title;
    private MultipartFile image;
    private String content;

    public BlogForm() {
    }

    public BlogForm(Long id, String user, Category category, String title, String content) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public BlogForm(Long id, String user, Category category, String title, MultipartFile image, String content) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.title = title;
        this.image = image;
        this.content = content;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

