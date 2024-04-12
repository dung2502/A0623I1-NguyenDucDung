package com.example.questionreal.service;

import com.example.questionreal.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IQuestionContentService {
    Page findByTitle(String name, Pageable pageable);
    List<QuestionContent> findAll();
    void save(QuestionContent questionContent);
    void delete(QuestionContent questionContent);
    QuestionContent getQuestionContentById(Integer id);
    Page<QuestionContent> getAll(Pageable pageable);

}
