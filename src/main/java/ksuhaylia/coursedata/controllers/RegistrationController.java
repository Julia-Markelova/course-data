package ksuhaylia.coursedata.controllers;

//класс считывает данные с заполненной регистрационной формы и добавляет нового пользователя в бд

import ksuhaylia.coursedata.BackEnd.EmailSender;
import ksuhaylia.coursedata.entity.Users;
import ksuhaylia.coursedata.repository.PostRepository;
import ksuhaylia.coursedata.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
@SessionAttributes({"name","lastname","email","password","biolog","geolog","antropolog","minerolog"} )
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private PostRepository postRepository;
    private EmailSender emailSender = new EmailSender();
    private LinkedHashMap<Users,Integer> confirmMap = new LinkedHashMap<>();
    private Logger logger = Logger.getLogger(RegistrationController.class);




    @RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity checkEmail(@RequestParam("email") String email)
    {
    if(userRepository.findUsersByEmail(email)!=null) {
        logger.info(" user with E-mail "+email+" is already exist");
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/sendCode", method = RequestMethod.GET)
    public ModelAndView sendRegisterCode(@RequestParam("name") String name, @RequestParam("lastname") String lastname,
                                         @RequestParam("e-mail") String email, @RequestParam("password") String password)
    {
        Map<String, String> model = new HashMap<>();
        Random random = new Random();
        int low = 1000;
        int height = 9999;
        int code = random.nextInt(height - low) + low;
        try {
            emailSender.sendEmail(email, code, "Код подтверждения регистрации", "Регистрация");
            logger.info("message sent on E-mail "+email);
        }catch (Exception ex){
            logger.error("can not sent message on E-mail "+email);
        }
        Users newUser = new Users(name, lastname, email, encoder.encode(password));
        confirmMap.put(newUser, code);
        model.put("name","");
        model.put("email",email);
        return new ModelAndView("../static/registrationCode",model);
    }

    @RequestMapping(value = "/addUser/confirm", method = RequestMethod.GET)
    public ModelAndView checkRegistration(@RequestParam("userEmail") String email , @RequestParam("usersCode") int usersCode){
        ModelAndView model = new ModelAndView();
        for (Map.Entry entry : new HashSet<>(confirmMap.entrySet())) {
            if(((Users)entry.getKey()).getEmail().equals(email)&&((Integer)entry.getValue()) == usersCode) {
                Users user = (Users) entry.getKey();
                user.setLogin(true);
                user.setGeolog(false);
                user.setBiolog(false);
                user.setMinerolog(false);
                user.setAntropolog(false);
                user.setAdmin(false);
                userRepository.save(user);
                confirmMap.remove(entry.getKey());
                model.addObject("name",(user.getUserName()));
                model.addObject("lastname",(user.getUserLastName()));
                model.addObject("password",user.getPassword());
                model.addObject("email", user.getEmail());
                model.addObject("biolog",user.getBiolog()?"true":"false");
                model.addObject("geolog",user.getGeolog()?"true":"false");
                model.addObject("antropolog",(user.getAntropolog())?"true":"false");
                model.addObject("minerolog",(user.getMinerolog())?"true":"false");
                model.addObject("title", "Личный кабинет");
                model.addObject("do","исследовать");
                model.addObject("pageName","Private Account");
                model.addObject("posts",postRepository.findPostsByTypeAndUser("Статья",user).size());
                model.addObject("videos", postRepository.findPostsByTypeAndUser("Видео",user).size());
                model.addObject("events",postRepository.findPostsByTypeAndUser("Событие",user).size());
                model.addObject("tests",postRepository.findPostsByTypeAndUser("Тест",user).size());
                model.setViewName("../static/privateAccount");
                logger.info("register user "+email);
                return model;
            }
        }
        logger.info("user "+email+" entered invalid code");
        model.addObject("name","Invalid code! Try again");
        model.setViewName("../static/registrationCode");
        return model;
    }


}