package com.example.experiment4.service;

import com.example.experiment4.aspect.MyInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    public void buyCar(){
        System.out.println("buy car()");
    }
    @MyInterceptor(MyInterceptor.AuthorityType.ADMIN)
    public void addUser(){
        System.out.println("addUser()");
    }
}
