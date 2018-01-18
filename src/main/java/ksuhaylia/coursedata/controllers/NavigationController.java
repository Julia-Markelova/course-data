package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.entity.Users;
import ksuhaylia.coursedata.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ymark on 18.12.2017.
 */
@Controller
@SessionAttributes({"email", "name", "lastname", "password", "biolog", "geolog", "antropolog", "minerolog"})
public class NavigationController {

    @Autowired
    private UserRepository userRepository;
    Logger logger = Logger.getLogger(NavigationController.class);

    @RequestMapping(value = "/showPrivateAccount")
    public ModelAndView returnAccountPage(Authentication authentication) {
        Users user = userRepository.findUsersByEmail(authentication.getName());
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/PrivateAccount");
        model.addObject("email", user.getEmail());
        model.addObject("name", user.getUserName());
        model.addObject("lastname", user.getUserLastName());
        model.addObject("biolog", user.getBiolog() ? "Есть!" : "");
        model.addObject("geolog", user.getGeolog() ? "Есть!" : "");
        model.addObject("antropolog", user.getAntropolog() ? "Есть!" : "");
        model.addObject("minerolog", user.getMinerolog() ? "Есть!" : "");
        model.addObject("title", "Личный кабинет");
        model.addObject("do", "исследовать");
        model.addObject("pageName", "Private Account");
        logger.info("user "+user.getEmail()+" is in private account now");
        return model;
    }


    @RequestMapping(value = "/showVideos")
    public ModelAndView showVideos() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Видео");
        model.addObject("do", "увидеть");
        model.addObject("pageName", "Videos");
        model.setViewName("../static/video");
        return model;
    }

    @RequestMapping(value = "/showLibrary")
    public ModelAndView showLibrary() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Библиотека");
        model.addObject("do", "прочесть");
        model.addObject("pageName", "Library");
        model.setViewName("../static/library");
        return model;

    }


    @RequestMapping(value = "/showTests")
    public ModelAndView showTests() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Тесты");
        model.addObject("do", "проверить");
        model.addObject("pageName", "Tests");
        model.setViewName("../static/tests");
        return model;
    }

    @RequestMapping(value = "/")
    public ModelAndView showNews() {
        ModelAndView model = new ModelAndView();
        // model.addObject("oldEmail", email);
        model.addObject("title", "Развитие жизни на Земле");
        model.addObject("do", "узнать");
        model.addObject("pageName", "News");
        model.setViewName("../static/news");
        return model;
    }

    @RequestMapping(value = "/showThemes")
    public ModelAndView showThemes() {
        ModelAndView model = new ModelAndView();
        model.addObject("oldEmail", "");
        model.setViewName("../static/Ksyu/Themes");
        return model;

    }


    @RequestMapping(value = "/showRead")
    public ModelAndView showRead() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Faq");
        model.addObject("do", "читать");
        model.addObject("pageName", "Read");
        model.setViewName("../static/faq");
        return model;

    }

    @RequestMapping(value = "/showEvents")
    public ModelAndView showEvents() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "События");
        model.addObject("do", "почувствовать");
        model.addObject("pageName", "Events");
        model.setViewName("../static/events");
        return model;
    }

    @RequestMapping(value = "/showInterakt")
    public ModelAndView showInterakt() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Интерактив");
        model.addObject("do", "исследовать");
        model.addObject("pageName", "Interakt");
        model.setViewName("../static/interakt/interakt");
        return model;
    }


    @RequestMapping(value = "/createPost")
    public ModelAndView createPost() {
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/Ksyu/createNewPostPage");
        return model;
    }

    @RequestMapping(value = "/createNew")
    public ModelAndView createNew() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Интерактив");
        model.addObject("do", "исследовать");
        model.addObject("pageName", "New post");
        model.setViewName("../static/Ksyu/createNewPostPage");
        return model;
    }

}



