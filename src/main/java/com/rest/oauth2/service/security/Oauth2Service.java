package com.rest.oauth2.service.security;

import com.google.gson.Gson;
import com.rest.oauth2.dto.UserDto;
import com.rest.oauth2.entity.User;
import com.rest.oauth2.dto.OAuthTokenDto;
import com.rest.oauth2.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class Oauth2Service {
    private final UserJpaRepo userJpaRepo;
    private final Gson gson;
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(UserDto userDto){
        userJpaRepo.save(User.builder()
                .userId(userDto.getUserId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .name(userDto.getName())
                .roles(Collections.singletonList(userDto.getRole().name()))
                .build());
    }

    @Transactional
    public OAuthTokenDto callbackTestAuthorization(String code){
        //DB내 저장된 클라이언트 아이디와 클라이언트시크릿을 base64인코딩 진행
        /*String credentials = "torder:testSecret";
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        //헤더에 베이직
        headers.add("Authorization", "Basic " + encodedCredentials);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("grant_type", "authorization_code");
        params.add("redirect_uri", "http://localhost:8081/oauth2/callback1");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/oauth/token", request, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return gson.fromJson(response.getBody(), OAuthTokenDto.class);
        }*/
        return null;
    }

    /**
     * authorization_code 인증 방식
     * @param code
     * code 방식 testUrl: http://localhost:8081/oauth/authorize?client_id=torder&redirect_uri=http://localhost:8081/oauth2/callback1&response_type=code&scope=read
     * implicit 방식 testUrl : http://localhost:8081/oauth/authorize?client_id=torder&redirect_uri=http://localhost:8081/oauth2/callback1&response_type=token&scope=read
     */
    @Transactional
    public OAuthTokenDto callbackTestAuthorizationCode(String code){
        //DB내 저장된 클라이언트 아이디와 클라이언트시크릿을 base64인코딩 진행
        String credentials = "torder:testSecret";
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        //헤더에 베이직
        headers.add("Authorization", "Basic " + encodedCredentials);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("grant_type", "authorization_code");
        params.add("redirect_uri", "http://localhost:8081/oauth2/callback1");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/oauth/token", request, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return gson.fromJson(response.getBody(), OAuthTokenDto.class);
        }
        return null;
    }

    @Transactional
    public OAuthTokenDto refreshToken(String refreshToken){
        String credentials = "testClientId:testSecret";
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Authorization", "Basic " + encodedCredentials);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("refresh_token", refreshToken);
        params.add("grant_type", "refresh_token");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/oauth/token", request, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return gson.fromJson(response.getBody(), OAuthTokenDto.class);
        }
        return null;
    }

}
