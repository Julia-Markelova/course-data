package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.entity.Users;
import ksuhaylia.coursedata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ymark on 15.12.2017.
 */
@Controller
public class AccountController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

@RequestMapping(value = "/changeUser")
    public @ResponseBody
    ResponseEntity changeUser(@RequestParam("userName") String name, @RequestParam("lastname") String lastname,
                              @RequestParam("email") String email, @RequestParam("password") String password,
                              Authentication authentication) {
    Users user = userRepository.findUsersByEmail(authentication.getName());
    if (!name.isEmpty())
        user.setUserName(name);
    if (!lastname.isEmpty())
        user.setUserLastName(lastname);
    if (!email.isEmpty()&&(userRepository.findUsersByEmail(email)==null||user==userRepository.findUsersByEmail(email)))
        user.setEmail(email);
    else
        return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
    if (!password.isEmpty())
        user.setPassword(encoder.encode(password));
    userRepository.save(user);
    return new ResponseEntity(HttpStatus.OK);

}
}
