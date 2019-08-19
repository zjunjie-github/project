package com.zjj.project.project.controller;

import com.zjj.project.project.dto.NotificationDTO;
import com.zjj.project.project.enums.NoyificationTypeEnum;
import com.zjj.project.project.model.User;
import com.zjj.project.project.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangjunjie 2019/8/19
 */

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest request, @PathVariable(name = "id") Long id) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        NotificationDTO notificationDTO = notificationService.read(id, user);
        if (NoyificationTypeEnum.REPLY_COMMENT.getType() == notificationDTO.getType() || NoyificationTypeEnum.REPLY_QUESTION.getType() == notificationDTO.getType()){
            return "redirect:/question/" + notificationDTO.getOuterid();
    }else {
            return "redirect:/";
        }
    }

}
