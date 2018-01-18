package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.entity.Posts;
import ksuhaylia.coursedata.entity.Users;
import ksuhaylia.coursedata.repository.PostRepository;
import ksuhaylia.coursedata.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class PostController {
Logger logger = Logger.getLogger(PostController.class);
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public ModelAndView addNewPost(@RequestParam("title") String title,
                                   @RequestParam("body") String body,
                                   @RequestParam("theme") String theme,
                                   @RequestParam("type") String type,
                                   @RequestParam("content") String content,
                                   Authentication auth) {
        Users user = userRepository.findUsersByEmail(auth.getName());
        Posts posts = new Posts(title,body,type,theme,user,content);
        postRepository.save(posts);
        logger.info("user "+user.getEmail()+" add new post about "+theme+" "+title);
       return new ModelAndView("../static/Ksyu/newPost");
    }

    @RequestMapping(value = "/addNew")
    public ModelAndView addCurrentNew(@RequestParam("type") String type) {
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/newPost");
        {
            switch (type) {
                case "read":
                    model.addObject("pageName", "New post");
                    model.addObject("body","Введите текст статьи");
                    model.addObject("content","Добавьте ссылку на картинку");
                    model.addObject("contentType","text");
                    model.addObject("type","Cтатья");
                    return model;
                case "video":
                    model.addObject("pageName", "New video");
                    model.addObject("body","Краткое описание");
                    model.addObject("content","Добавьте ссылку на видео!");
                    model.addObject("contentType","text");
                    model.addObject("type","Видеоконтент");
                    return model;
                case "events":
                    model.addObject("pageName", "New event");
                    model.addObject("body","Что и где?");
                    model.addObject("content","Когда?");
                    model.addObject("contentType","date");
                    model.addObject("type","Событие");
                    return model;
                case "tests":
                    model.addObject("pageName", "New test");
                    model.addObject("body","Краткое описание");
                    model.addObject("content","Добавьте ссылку на тест");
                    model.addObject("contentType","text");
                    model.addObject("type","Тест");
                    return model;
            }
        }
        model.setViewName("../static/Ksyu/createNewPostPage");
        return model;

    }

    @RequestMapping(value = "/updateVideos")
    public @ResponseBody  List<Posts> updateVideos() {
        List<Posts>  posts = postRepository.findPostsByType("Видео");
        Collections.reverse(posts);
        return posts;
    }

    @RequestMapping(value = "/updatePosts")
    public @ResponseBody  List<Posts> updatePosts() {
        List<Posts>  posts = postRepository.findPostsByType("Статья");
        Collections.reverse(posts);
        return posts;
    }
    @RequestMapping(value = "/updateEvents")
    public @ResponseBody  List<Posts> updateEvents() {
        List<Posts>  posts = postRepository.findPostsByType("Событие");
        Collections.reverse(posts);
        return posts;
    }
    @RequestMapping(value = "/updateTests")
    public @ResponseBody  List<Posts> updateTests() {
        List<Posts>  posts = postRepository.findPostsByType("Тест");
        Collections.reverse(posts);
        return posts;
    }
    @RequestMapping(value = "/updateNews")
    public @ResponseBody  List<Posts> updateNews() {
        List<Posts> posts = (List<Posts>) postRepository.findAll();
        Collections.reverse(posts);
        return posts;
    }
}