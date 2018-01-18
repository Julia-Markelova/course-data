package ksuhaylia.coursedata.controllers;

import jdk.nashorn.internal.ir.annotations.Reference;
import ksuhaylia.coursedata.entity.Posts;
import ksuhaylia.coursedata.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by ymark on 18.01.2018.
 */
@Controller
public class ThemeController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value = "/era")
    public ModelAndView era(){
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/themes");
        model.addObject("pageName","Эры");
        model.addObject("title","Эры");
        model.addObject("do", "узнать");
        model.addObject("theme","Эры");
        return model;
    }

    @RequestMapping(value = "/relief")
    public ModelAndView relief(){
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/themes");
        model.addObject("pageName","Рельеф");
        model.addObject("title","Рельеф");
        model.addObject("do", "узнать");
        model.addObject("theme","Изменение рельефа");
        return model;
    }
    @RequestMapping(value = "/animal")
    public ModelAndView animal(){
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/themes");
        model.addObject("pageName","Животные");
        model.addObject("title","Флора и фауна");
        model.addObject("do", "узнать");
        model.addObject("theme","Флора и фауна");
        return model;
    }
    @RequestMapping(value = "/remain")
    public ModelAndView remain(){
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/themes");
        model.addObject("pageName","Останки");
        model.addObject("title","Найденные останки");
        model.addObject("do", "узнать");
        model.addObject("theme","Найденные останки");
        return model;
    }
    @RequestMapping(value = "/mineral")
    public ModelAndView mineral(){
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/themes");
        model.addObject("pageName","Минералы");
        model.addObject("title","Минералы");
        model.addObject("do", "узнать");
        model.addObject("theme","Минералы");
        return model;
    }
    @RequestMapping(value = "/continent")
    public ModelAndView continent(){
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/themes");
        model.addObject("pageName","Континенты");
        model.addObject("title","Континенты");
        model.addObject("do", "узнать");
        model.addObject("theme","Континенты");
        return model;
    }

    @RequestMapping(value = "/loadTheme")
    public @ResponseBody
    List<Posts> load(@RequestParam("theme") String theme){
       List<Posts> themes = postRepository.findPostsByTheme(theme);
       Collections.reverse(themes);
       return themes;
    }



}
