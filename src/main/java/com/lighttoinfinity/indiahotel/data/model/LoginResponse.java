package com.lighttoinfinity.indiahotel.data.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    private final String accessToken;

}
