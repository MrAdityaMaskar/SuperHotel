package com.lighttoinfinity.indiahotel.accounts.service;

import com.lighttoinfinity.indiahotel.accounts.config.JwtIssuer;
import com.lighttoinfinity.indiahotel.accounts.config.UserPrincipal;
import com.lighttoinfinity.indiahotel.data.model.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtIssuer jwtIssuer;

    private final DaoAuthenticationProvider daoAuthenticationProvider;

    public LoginResponse attemptLogin(String username, String password){

        var authentication = daoAuthenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal =(UserPrincipal) authentication.getPrincipal();

        var roles = principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        var token = jwtIssuer.issue(principal.getUserId(), principal.getUsername(), roles);
        return LoginResponse.builder().accessToken(token).build();
    }
}
