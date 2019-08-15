package com.zjj.project.project.controller;

import com.zjj.project.project.dto.QuestionDTO;
import com.zjj.project.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhangjunjie 2019/8/12
 */

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        //累加阅读（浏览）数
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
