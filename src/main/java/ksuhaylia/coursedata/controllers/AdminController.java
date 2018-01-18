package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.BackEnd.EmailSender;
import ksuhaylia.coursedata.entity.Posts;
import ksuhaylia.coursedata.entity.Users;
import ksuhaylia.coursedata.repository.PostRepository;
import ksuhaylia.coursedata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

/**
 * Created by ymark on 18.01.2018.
 */
@Controller
public class AdminController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    EmailSender emailSender = new EmailSender();

    @RequestMapping("/developers")
    public ModelAndView newPosts(){
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/userPost");
        model.addObject("pageName","Новые публикации");
        model.addObject("title","Новые публикации");
        model.addObject("do", "узнать");
        model.addObject("theme",false);
        model.addObject("js","allowPost");
        return model;
    }


    @RequestMapping(value = "/developerAllow")
    public @ResponseBody
    List<Posts> updateNews() {
        return postRepository.findPostsByAllow(false);
    }

    @RequestMapping(value="/allow")
    public @ResponseBody String allow(@RequestParam("id") int id){
        Posts posts = postRepository.findOne(id);
        posts.setAllow(true);
        postRepository.save(posts);
        Users users = posts.getUser();
        emailSender.sendEmail(users.getEmail(),3,"Ваш пост "+posts.getTitle()+" опубликован! :","Публикация поста");
        return "Запись опубликована";
    }

}



