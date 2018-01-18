package ksuhaylia.coursedata.BackEnd;

import ksuhaylia.coursedata.entity.Users;
import ksuhaylia.coursedata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDeniedServer implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        Users user = userRepository.findUsersByEmail(s);
        System.out.println(user + "-----------------------------------------------------");
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        List<GrantedAuthority> authorityList = new ArrayList<>();
        if(user.getLogin())
            authorityList.add(new SimpleGrantedAuthority("ROLE_login"));
        if(user.getGeolog())
            authorityList.add(new SimpleGrantedAuthority("ROLE_geolog"));
        if(user.getBiolog())
            authorityList.add(new SimpleGrantedAuthority("ROLE_biolog"));
        if(user.getMinerolog())
            authorityList.add(new SimpleGrantedAuthority("ROLE_minerolog"));
        if(user.getAntropolog())
            authorityList.add(new SimpleGrantedAuthority("ROLE_antropolog"));
        if(user.getAdmin())
            authorityList.add(new SimpleGrantedAuthority("ROLE_admin"));
        System.out.println(authorityList);
        return new User(user.getEmail(),user.getPassword(),authorityList);
    }
}