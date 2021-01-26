package com.evolyb.oauth;

import com.evolyb.oauth.entity.*;
import com.evolyb.oauth.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OauthApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser appUser = new AppUser(null,"admin","1","ROLE_ADMIN","neu.nganhang@gmail.com");
        userRepository.save(appUser);
    }
}
