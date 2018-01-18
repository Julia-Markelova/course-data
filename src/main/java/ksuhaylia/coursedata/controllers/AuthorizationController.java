package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.BackEnd.EmailSender;
import ksuhaylia.coursedata.entity.Users;
import ksuhaylia.coursedata.repository.PostRepository;
import ksuhaylia.coursedata.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * Created by ymark on 13.12.2017.
 */
@Controller
public class AuthorizationController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    private EmailSender emailSender = new EmailSender();
    private LinkedHashMap<String,Integer> confirmMap = new LinkedHashMap<>();
    private Logger logger =Logger.getLogger(AuthorizationController.class);


    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView authorize(Authentication authentication) {
        ModelAndView model = new ModelAndView();
        Users user = userRepository.findUsersByEmail(authentication.getName());
        model.setViewName("../static/privateAccount");
        model.addObject("email", user.getEmail());
        model.addObject("name", user.getUserName());
        model.addObject("lastname", user.getUserLastName());
        model.addObject("biolog",user.getBiolog()?"Есть!":"");
        model.addObject("geolog",user.getGeolog()?"Есть!":"");
        model.addObject("antropolog",user.getAntropolog()?"Есть!":"");
        model.addObject("minerolog",user.getMinerolog()?"Есть!":"");
        model.addObject("title", "Личный кабинет");
        model.addObject("do","исследовать");
        model.addObject("pageName","Private Account");
        model.addObject("posts",postRepository.findPostsByTypeAndUser("Статья",user).size());
        model.addObject("videos", postRepository.findPostsByTypeAndUser("Видеоконтент",user).size());
        model.addObject("events",postRepository.findPostsByTypeAndUser("Событие",user).size());
        model.addObject("tests",postRepository.findPostsByTypeAndUser("Тест",user).size());
        return model;
    }

    @RequestMapping(value = "/checkPassword", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity incorrectEmail(Authentication auth) {
        if(userRepository.findUsersByEmail(auth.getName())==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/resetPasswort", method = RequestMethod.POST)
    public @ResponseBody String sendCode(Authentication auth){
        String email=userRepository.findUsersByEmail(auth.getName()).getEmail();
        Random random = new Random();
        int low = 1000000;
        int height = 99999999;
        int code = random.nextInt(height - low) + low;
        emailSender.sendEmail(email, code, "Новый пароль", "Смена пароля");
        confirmMap.put(email,code);
        return "ok";
    }


    @RequestMapping(value = "/resetPassword/confirm", method = RequestMethod.GET)
    public ModelAndView confirmPassword(Authentication auth, @RequestParam("usersCode") int usersCode) {
       ModelAndView model=new ModelAndView();
       String eMail = userRepository.findUsersByEmail(auth.getName()).getEmail();
        for (Map.Entry entry : new HashSet<>(confirmMap.entrySet())) {
            if(entry.getKey().equals(eMail)&& entry.getValue().equals(usersCode)){
                Users user = userRepository.findUsersByEmail(eMail);
                user.setPassword(String.valueOf(usersCode));
                user.setLogin(true);
                userRepository.save(user);
                model.setViewName("../static/privateAccount");
                model.addObject("email",user.getEmail());
                model.addObject("oldEmail",user.getEmail());
                model.addObject("name",user.getUserName());
                model.addObject("lastname",user.getUserLastName());
                model.addObject("password",user.getPassword());
                model.addObject("message","");
                model.addObject("biolog",(user.getBiolog()!=null)?"Есть!":"");
                model.addObject("geolog",(user.getGeolog()!=null)?"Есть!":"");
                model.addObject("antropolog",(user.getAntropolog()!=null)?"Есть!":"");
                model.addObject("minerolog",(user.getMinerolog()!=null)?"Есть!":"");
                model.addObject("title", "Личный кабинет");
                model.addObject("do","исследовать");
                model.addObject("pageName","Private account");
                model.addObject("posts",postRepository.findPostsByTypeAndUser("Статья",user).size());
                model.addObject("videos", postRepository.findPostsByTypeAndUser("Видеоконтент",user).size());
                model.addObject("events",postRepository.findPostsByTypeAndUser("Событие",user).size());
                model.addObject("tests",postRepository.findPostsByTypeAndUser("Тест",user).size());
                confirmMap.remove((String)entry.getKey());
                return model;
            }
        }
        model.setViewName("../static/resetPassword");
        model.addObject("message","Invalid code!");
        return model;
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public ModelAndView confirmPassword() {
        ModelAndView model=new ModelAndView();
        model.setViewName("../static/resetPassword");
        model.addObject("message","");
        return model;
    }


    @RequestMapping(value="/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        logger.info("user "+auth.getName()+" is log out");
        return new ModelAndView("../static/authorizationPage");
    }
}
