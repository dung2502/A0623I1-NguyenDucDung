package com.example.question.repository;

import com.example.question.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionContentRepository extends JpaRepository<QuestionContent,Integer> {
    Page<QuestionContent> findQuestionContentByTitleContaining(String title, Pageable pageable);
}
