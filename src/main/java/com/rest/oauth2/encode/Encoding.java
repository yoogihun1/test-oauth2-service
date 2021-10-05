package com.rest.oauth2.encode;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Encoding {
    public static void main(String[] args) {
        //인코딩 되어 나온 값을 client_detail 테이블의 secret 컬럼에 넣는다.
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.printf("testSecret : %s\n",passwordEncoder.encode("testSecret"));

        
    }
}
