package com.example.questionreal.repository;

import com.example.questionreal.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface QuestionContentRepository extends JpaRepository<QuestionContent, Integer> {
    Page<QuestionContent> findQuestionContentByTitle(String title, Pageable pageable);
}
