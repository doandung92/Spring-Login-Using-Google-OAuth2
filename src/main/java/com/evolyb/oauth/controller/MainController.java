package com.evolyb.oauth.controller;

import com.evolyb.oauth.config.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("/admin")
    public String index(Authentication authentication){
        if (authentication.getPrincipal() instanceof MyUserDetails) {
            MyUserDetails user = (MyUserDetails) authentication.getPrincipal();
            System.out.println(user.getUsername());
            System.out.println(user.getAuthorities());
            System.out.println(user.getEmail());
        }
        return "Hello";
    }
}
