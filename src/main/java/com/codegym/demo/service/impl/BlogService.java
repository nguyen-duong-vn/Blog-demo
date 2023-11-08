package com.codegym.demo.service.impl;

import com.codegym.demo.model.Blog;
import com.codegym.demo.repository.IBlogRepository;
import com.codegym.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Blog addBlog(Blog blog) {
         return blogRepository.save(blog);
    }

    @Override
    public boolean deleteBlog(long id) {
        if(id >= 1){
            Blog blog = blogRepository.getById(id);
            if(blog != null){
                blogRepository.delete(blog);
                return true;
            }
        }
        return false;
    }

    @Override
    public Blog updateBlog(long id, Blog blog) {
        if(blog != null){
            Blog blog1 = blogRepository.getById(id);
            if(blog1 != null){
                blog1.setTitle(blog.getTitle());
                blog1.setContent(blog.getContent());
                blog1.setAuthor(blog.getAuthor());
                return blog1;
            }
        }
        return null;
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getById(long id) {
        return blogRepository.findById(id).orElse(null);
    }
}
