package com.lighttoinfinity.indiahotel.accounts.web.api;

import com.lighttoinfinity.indiahotel.accounts.config.JwtIssuer;
import com.lighttoinfinity.indiahotel.accounts.config.UserPrincipal;
import com.lighttoinfinity.indiahotel.accounts.service.AuthService;
import com.lighttoinfinity.indiahotel.data.model.LoginRequest;
import com.lighttoinfinity.indiahotel.data.model.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        return authService.attemptLogin(request.getUsername(), request.getPassword());
    }
}
