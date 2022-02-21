package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.UserForm;

@Controller
public class UserController {

    @RequestMapping("/show")
    public ModelAndView show(ModelAndView mav) {
        UserForm form = new UserForm();

        form.setId("1");
        form.setName("Ken");
        form.setEmail("ken@mail.com");

        mav.addObject("UserForm", form);
        mav.setViewName("user");

        return mav;
    }

}
