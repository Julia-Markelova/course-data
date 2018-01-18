package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.BackEnd.EmailSender;
import ksuhaylia.coursedata.entity.Users;
import ksuhaylia.coursedata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ymark on 18.01.2018.
 */
@Controller
public class BackConnection {

    private EmailSender emailSender = new EmailSender();
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "//messageForAdmin")
    public ModelAndView sendToAdmin(@RequestParam("Name") String name, @RequestParam("Message") String message, Authentication auth) {
        Users users = userRepository.findUsersByEmail(auth.getName());
        emailSender.sendEmail("lifeintheearth@mail.ru",3,message+" :",
                "Пользователь "+users.getEmail()+" оставил Вам сообщение" );
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/posted");
        model.addObject("pageName", "New post");
        model.addObject("title","Спасибо за обратную связь!");
        return model;
    }
}
