package com.lighttoinfinity.indiahotel.data.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class LoginRequest {

    private String username;
    private String password;
}

