package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.entity.*;
import ksuhaylia.coursedata.repository.ErasRepository;
import ksuhaylia.coursedata.repository.FloraFaunaRepository;
import ksuhaylia.coursedata.repository.HumanRepository;
import ksuhaylia.coursedata.repository.MineralsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {



    @RequestMapping("/signin")
    public ModelAndView test1() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Развитие жизни на Земле");
        model.addObject("do","узнать");
        model.addObject("pageName","Sign in");
        model.setViewName("../static/authorizationPage");
        return model;

    }

}
