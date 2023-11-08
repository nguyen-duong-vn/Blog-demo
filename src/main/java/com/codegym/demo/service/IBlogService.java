package com.codegym.demo.service;

import com.codegym.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    Blog addBlog(Blog blog);
    boolean deleteBlog(long id);
    Blog updateBlog(long id,Blog blog);
    List<Blog> getAll();
    Blog getById(long id);
}
