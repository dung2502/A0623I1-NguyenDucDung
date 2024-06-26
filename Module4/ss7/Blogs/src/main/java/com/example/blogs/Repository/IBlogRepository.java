package com.example.blogs.Repository;

import com.example.blogs.Model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> searchAllByTitleContainingAndCategoryCategoryNameContaining(String title, String categoryName, Pageable pageable);
    Page<Blog> searchAllByTitleContaining(String title, Pageable pageable);
}
