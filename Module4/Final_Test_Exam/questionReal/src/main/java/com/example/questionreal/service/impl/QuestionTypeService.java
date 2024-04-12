package com.example.questionreal.service.impl;

import com.example.questionreal.model.QuestionType;
import com.example.questionreal.repository.QuestionTypeRepository;
import com.example.questionreal.service.IQuestionTypeService;
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
