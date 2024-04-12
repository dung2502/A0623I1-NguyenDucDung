package com.example.blogs.Service;



import com.example.blogs.Model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAllByTitleAndCategory(String title, String categoryName, Pageable pageable);
    Page<Blog> findAllByTitle(String title, Pageable pageable);
}
