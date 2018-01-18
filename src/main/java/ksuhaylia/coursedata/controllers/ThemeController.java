package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        return model;
    }
}
