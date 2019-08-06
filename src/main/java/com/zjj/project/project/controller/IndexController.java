package com.zjj.project.project.controller;


import com.zjj.project.project.dto.QuestionDTO;
import com.zjj.project.project.mapper.UserMapper;
import com.zjj.project.project.model.User;
import com.zjj.project.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhangjunjie 2019/7/31
 */

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0 )
        //遍历cookies，得到token
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.fingByToken(token);
                if (user != null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        List<QuestionDTO> questionList = questionService.list();
        model.addAttribute("questions",questionList);
        return "index";}
}
