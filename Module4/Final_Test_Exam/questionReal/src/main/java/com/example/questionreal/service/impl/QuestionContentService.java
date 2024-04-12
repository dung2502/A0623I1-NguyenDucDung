package com.example.questionreal.service.impl;

import com.example.questionreal.model.QuestionContent;
import com.example.questionreal.repository.QuestionContentRepository;
import com.example.questionreal.service.IQuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionContentService implements IQuestionContentService {
    @Autowired
    private QuestionContentRepository questionContentRepository;
    @Override
    public Page findByTitle(String name, Pageable pageable) {
        return questionContentRepository.findQuestionContentByTitle(name,pageable) ;
    }

    @Override
    public List<QuestionContent> findAll() {
        return questionContentRepository.findAll();
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);

    }

    @Override
    public void delete(QuestionContent questionContent) {
        questionContentRepository.delete(questionContent);
    }

    @Override
    public QuestionContent getQuestionContentById(Integer id) {
        return questionContentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<QuestionContent> getAll(Pageable pageable) {
        return questionContentRepository.findAll(pageable);
    }
}
