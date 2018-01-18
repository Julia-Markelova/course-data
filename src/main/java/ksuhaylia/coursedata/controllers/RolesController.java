package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.BackEnd.EmailSender;
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
 * Created by ymark on 17.12.2017.
 */
@Controller
public class RolesController {

    @Autowired
    private UserRepository userRepository;
    private EmailSender emailSender = new EmailSender();
    private Logger logger = Logger.getLogger(RolesController.class);

    @RequestMapping(value = "/checkRoleTest")
    public ModelAndView sendResults(@RequestParam("1") String answer1, @RequestParam("2") String answer2,
                                    @RequestParam("3") String answer3, @RequestParam("4") String answer4,
                                    @RequestParam("5") String answer5, @RequestParam("6") String answer6,
                                    @RequestParam("7") String answer7, @RequestParam("8") String answer8,
                                    @RequestParam("9") String answer9, @RequestParam("10") String answer10,
                                    @RequestParam("11") String answer11, @RequestParam("12") String answer12,
                                    Authentication auth) {
        Users user =userRepository.findUsersByEmail(auth.getName());
        String email = user.getEmail();
        String bio="Поздравляем! Ваша роль - биолог! Теперь Вы получаете можете исследовать  развитие животных!";
        String antro = "Поздравляем! Ваша роль - антрополог! Теперь Вы можете исследовать  развитие человека!";
        String geo = "Поздравляем! Ваша роль - геолог! Теперь Вы  можете исследовать динамику рельефа!";
        String min = "Поздравляем! Ваша роль - минеролог! Теперь Вы  можете изучать минералы!";
        String noRole="К сожалению, Ваших знаний недостаточно чтобы получить роль...Советуем подробнее изучить разделы нашего сайта и затем пройти тест еще раз. Успехов!";
        if(answer1.equals("true")&&answer2.equals("true")&&answer7.equals("true")){
            emailSender.sendEmail(email,0,bio,"Получение роли");
            user.setBiolog(true);
            userRepository.save(user);
            logger.info("user "+email+" get role biolog");

        }
        if(answer3.equals("true")&&answer4.equals("true")&&answer6.equals("true")){
            emailSender.sendEmail(email,0,min,"Получение роли");
            user.setMinerolog(true);
            userRepository.save(user);
            logger.info("user "+email+" get role minerolog");
        }
        if(answer10.equals("true")&&answer11.equals("true")&&answer12.equals("true")){
            emailSender.sendEmail(email,0,geo,"Получение роли");
            user.setGeolog(true);
            userRepository.save(user);
            logger.info("user "+email+" get role geograg");
        }
        if(answer5.equals("true")&&answer8.equals("true")&&answer9.equals("true")){
            emailSender.sendEmail(email,0,antro,"Получение роли");
            user.setAntropolog(true);
            userRepository.save(user);
            logger.info("user "+email+" get role antropolog");
        }
        else
            emailSender.sendEmail(email, 0, noRole, "Получение роли");
            ModelAndView model = new ModelAndView();
            model.addObject("pageName", "Role test");
            model.addObject("title",user.getUserName()+" спасибо за прохождение теста! Ваш результат можете посмотреть" +
                    "на почте или в личном кабинете!");
            model.setViewName("../static/posted");
        return model;
    }

    @RequestMapping(value = "/toTheRoleTest" )
    public ModelAndView returnTestPage(){
        ModelAndView model=new ModelAndView();
        model.setViewName("../static/Roles/RoleTest");
        return model;
    }
}
