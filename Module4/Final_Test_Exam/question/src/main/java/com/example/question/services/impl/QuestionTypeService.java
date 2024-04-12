package com.example.question.services.impl;

import com.example.question.model.QuestionType;
import com.example.question.repository.QuestionTypeRepository;
import com.example.question.services.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    private QuestionTypeRepository questionTypeRepository;
    @Override
    public List<QuestionType> getAll() {
        return questionTypeRepository.findAll();
    }
}
