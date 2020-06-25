package com.codenation.centraldeerros.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String args[]){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123"));
//$2a$10$/LGFexCfbBO3KoOHRB6rAelPWoDskLMPOS7VfMemNj1nxtqYNR5ji
    }
//ctrl + shift + F10
}
