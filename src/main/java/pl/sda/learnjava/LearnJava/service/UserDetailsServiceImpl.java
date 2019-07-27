package pl.sda.learnjava.LearnJava.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.learnjava.LearnJava.model.Role;
import pl.sda.learnjava.LearnJava.model.Student;
import pl.sda.learnjava.LearnJava.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    StudentRepository studentRepository;
    @Autowired
    public UserDetailsServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Student> byLogin = studentRepository.findByLogin(login);
        Student user = byLogin.orElseThrow(() -> new
                UsernameNotFoundException("Not found user with login: " + login));

        List<GrantedAuthority> admin = new ArrayList<>();
        admin.add(new SimpleGrantedAuthority("ROLE_" + user.getRoles().iterator().next().getName()));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), admin);
    }
}
