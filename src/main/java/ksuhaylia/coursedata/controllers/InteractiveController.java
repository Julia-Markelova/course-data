package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.entity.*;
import ksuhaylia.coursedata.repository.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by ymark on 19.12.2017.
 */
@Controller
@SessionAttributes("email")
public class InteractiveController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FloraFaunaRepository floraFaunaRepository;

    @Autowired
    private ReliefRepository reliefRepository;

    @Autowired
    private MineralsRepository mineralsRepository;

    @Autowired
    private HumanRepository humanRepository;

    private Logger logger = Logger.getLogger(InteractiveController.class);

    @RequestMapping(value = "/geograf")
    public ModelAndView showGeologPage(@RequestParam("email") String email){
        ModelAndView model = new ModelAndView();
        Users user=userRepository.findUsersByEmail(email);
        model.addObject("email", email);
        if (user != null && user.getLogin()!=null && user.getGeolog()!=null) {
            model.setViewName("../static/Ksyu/interakt/geograf");
            return model;
        }
        logger.warn("permission denied");
        model.setViewName("../static/Ksyu/interakt/noRole");
        return model;
    }

    @RequestMapping(value = "/minerolog")
    public ModelAndView showMinerologPage(@RequestParam("email") String email){
        ModelAndView model = new ModelAndView();
        Users user=userRepository.findUsersByEmail(email);
        model.addObject("email", email);
        if (user != null && user.getLogin()!=null && user.getMinerolog()!=null) {
            model.setViewName("../static/Ksyu/interakt/minerolog");
            return model;
        }
        logger.warn("permission denied");
        model.setViewName("../static/Ksyu/interakt/noRole");
        return model;
    }

    @RequestMapping(value = "/antropolog")
    public ModelAndView showAntropologPage(@RequestParam("email") String email){
        ModelAndView model = new ModelAndView();
        Users user=userRepository.findUsersByEmail(email);
        model.addObject("email", email);
        if (user != null && user.getLogin()!=null && user.getAntropolog()!=null) {
            model.setViewName("../static/Ksyu/interakt/antropolog");
            return model;
        }
        logger.warn("permission denied");
        model.setViewName("../static/Ksyu/interakt/noRole");
        return model;
    }

    @RequestMapping(value = "/biolog")
    public ModelAndView showBiologPage(@RequestParam("email") String email){
        ModelAndView model = new ModelAndView();
        Users user=userRepository.findUsersByEmail(email);
        model.addObject("email", email);
        if (user!=null && user.getLogin()!=null && user.getBiolog()!=null) {
            model.setViewName("../static/Ksyu/interakt/biolog");
            return model;
        }
        logger.warn("permission denied");
        model.setViewName("../static/Ksyu/interakt/noRole");
        return model;
    }


    @RequestMapping(value="/findAnimals")
    public @ResponseBody
    List<FloraFauna> findAnimals(@RequestParam("foodType") String foodType){
        return floraFaunaRepository.findFloraFaunaByFoodType(foodType);
    }

    @RequestMapping(value="/findHuman")
    public @ResponseBody
    List<Human> findHuman(@RequestParam("humanName") String name){
        return humanRepository.findHumansByHumanName(name);
    }

    @RequestMapping(value="/findMineral")
    public @ResponseBody
    List<Minerals> findMineral(@RequestParam("price")BigInteger price){
        return mineralsRepository.findMineralsByPriceBefore(price);
    }

    @RequestMapping(value="/findRelief")
    public @ResponseBody
    List<Relief> findRelief(@RequestParam("reliefHeight") double height){
        return reliefRepository.findReliefsByHeightAfter(height);
    }
}
