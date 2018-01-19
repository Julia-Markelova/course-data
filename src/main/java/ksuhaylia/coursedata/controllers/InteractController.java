package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.entity.FloraFauna;
import ksuhaylia.coursedata.repository.FloraFaunaRepository;
import ksuhaylia.coursedata.repository.MineralsRepository;
import ksuhaylia.coursedata.repository.RemainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ymark on 18.01.2018.
 */
@Controller
public class InteractController {

    @Autowired
    private FloraFaunaRepository floraFaunaRepository;
    @Autowired
    private MineralsRepository mineralsRepository;

    @RequestMapping(value = "/findAnimal")
    public @ResponseBody
    List<FloraFauna> findAnimal(@RequestParam("continent") String continent) {
        if (!continent.equals(""))
            return floraFaunaRepository.findFloraFaunaByAreal(continent);
        return null;
    }


    @RequestMapping(value = "/findMineral")
    public @ResponseBody
    List<FloraFauna> findMineral(@RequestParam("continent") String continent) {
        if (!continent.equals(""))
            return floraFaunaRepository.findFloraFaunaByAreal(continent);
        return null;
    }

    @RequestMapping(value = "/mineralInteract")
    public ModelAndView biologyInteract() {
        ModelAndView model = new ModelAndView();
        model.setViewName("../static/mineral");
        model.addObject("pageName", "Minerals");
        return model;
    }
}

