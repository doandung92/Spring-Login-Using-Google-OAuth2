package com.evolyb.oauth.config;

import com.evolyb.oauth.entity.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.oauth2.core.user.*;

import java.util.*;
import java.util.stream.*;

public class MyUserDetails implements UserDetails {
    private String userName;
    private String password;
    private String email;
    private List<GrantedAuthority> authorities;

    public MyUserDetails() {
    }

    public MyUserDetails(OAuth2User oAuth2User) {
        this.userName = "Oauth";
        this.password = "1";
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_TEST"));
        this.email = oAuth2User.getAttribute("email");
    }

    public MyUserDetails(AppUser user){
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail(){
        return this.email;
    }
}
