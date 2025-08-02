package org.nevesdev.comanda.service.security;

import org.nevesdev.comanda.dto.bar.BarCreate;
import org.nevesdev.comanda.dto.user.UserRegister;
import org.nevesdev.comanda.dto.user.UserResponse;
import org.nevesdev.comanda.exceptions.UsernameException;
import org.nevesdev.comanda.model.bar.Address;
import org.nevesdev.comanda.model.bar.Bar;
import org.nevesdev.comanda.model.user.Role;
import org.nevesdev.comanda.model.user.User;
import org.nevesdev.comanda.repository.BarRepository;
import org.nevesdev.comanda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BarRepository barRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public UserResponse createUser(UserRegister userRegister) {
        if(userRegister.getPasswd().isBlank() || userRegister.getUsername().isBlank()) {
            throw new UsernameException("Username cannot be empty", 409);
        }
        if(userRepository.existsByUsername(userRegister.getUsername())) {
            throw new UsernameException("Username already exists", 409);
        }
        userRegister.setPasswd(encryptPassword(userRegister.getPasswd()));
        User user = new User(userRegister);
        Bar bar = new Bar(userRegister.getBarCreate().getBarName(), userRegister.getBarCreate().getAddress());
        List<Bar> bars = barRepository.findAll();
        Optional<Bar> b = bars.stream().filter(bar1 -> bar1.getBarName().equals(bar.getBarName())).findFirst();
        if(b.isEmpty()) {
            user.setBar(barRepository.save(bar));
        }
        else {
            user.setBar(b.get());
        }
        user = userRepository.save(user);
        return new UserResponse(user.getUsername(), user.getRole());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createUser() {
        if(!userRepository.existsByUsername(("Super"))) {
            UserRegister ur = new UserRegister();
            BarCreate bc = new BarCreate();
            Address address = new Address();
            address.setStreetName("Rua 1");
            address.setStreetNumber("800");
            bc.setBarName("Bar exemplo");
            bc.setAddress(address);
            ur.setUsername("Super");
            ur.setPasswd("Super@123");
            ur.setRole(Role.SUPER);
            ur.setBarCreate(bc);
            this.createUser(ur);
        }
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

}
