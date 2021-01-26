package com.evolyb.oauth.config;

import com.evolyb.oauth.entity.*;
import com.evolyb.oauth.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.oauth2.core.user.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = userRepository.findByUsername(username);
        user.orElseThrow(()-> new UsernameNotFoundException("Not found: "+username));
        return new MyUserDetails(user.get());
    }

    public MyUserDetails buildUserDetailsFromOauth2User(OAuth2User oAuth2User) {
        return new MyUserDetails(oAuth2User);
    }
}
