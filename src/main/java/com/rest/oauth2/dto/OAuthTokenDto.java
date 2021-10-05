package com.rest.oauth2.dto;

import lombok.Getter;
import lombok.Setter;

//OAuth서버에 발급되는 토큰을 받기위한 Dto
@Getter
@Setter
public class OAuthTokenDto {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private long expires_in;
    private String scope;
}
