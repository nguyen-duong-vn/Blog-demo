package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IBlogService blogService;
    @PostMapping("/create")
    public ModelAndView addBlog(@RequestBody Blog blog){
        ModelAndView mav = new ModelAndView("home");
        blogService.addBlog(blog);
        return mav;
    }
    @GetMapping("/home")
    public ModelAndView getHomePage(){
        List<Blog> blog = blogService.getAll();
        ModelAndView mav = new ModelAndView("home");
        mav.addObject(blog);
        return mav;
    }
    @DeleteMapping("/delete{id}")
    public ModelAndView deleteBlog(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView("home");
        blogService.deleteBlog(id);
        return mav;
    }
    @PutMapping("/update/{id}")
    public ModelAndView updateBlog(@PathVariable ("id") long id,@RequestBody Blog blog ){
        ModelAndView mav = new ModelAndView("home");
        blogService.updateBlog(id,blog);
        return mav;
    }
}
