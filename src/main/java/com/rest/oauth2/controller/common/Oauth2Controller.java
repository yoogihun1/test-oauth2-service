package com.rest.oauth2.controller.common;

import com.rest.oauth2.dto.UserDto;
import com.rest.oauth2.dto.OAuthTokenDto;
import com.rest.oauth2.service.security.Oauth2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/oauth2")
public class Oauth2Controller {

    private final Oauth2Service oauth2Service;

    //로그인 계정을 등록할 수 있는 Api
    @PostMapping(value="/create")
    public ResponseEntity createUser(@RequestBody UserDto userDto){
        oauth2Service.createUser(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    //oauth auth서버에 토큰을 요청하는 Api
    @GetMapping(value = "/callback")
    public ResponseEntity<OAuthTokenDto> callbackAuthorizationCode(@RequestParam String code) {
        return ResponseEntity.ok(oauth2Service.callbackTestAuthorization(code));
    }

    //authorization_code, implicit 인증 방식
    @GetMapping(value = "/callback1")
    public ResponseEntity<OAuthTokenDto> callbackTestAuthorizationCode(@RequestParam String code) {
        return ResponseEntity.ok(oauth2Service.callbackTestAuthorizationCode(code));
    }

    //리프레시 토큰을 발급요청하는 Api
    @GetMapping(value = "/token/refresh")
    public ResponseEntity<OAuthTokenDto> refreshToken(@RequestParam String refreshToken) {
        return ResponseEntity.ok(oauth2Service.refreshToken(refreshToken));
    }
}
