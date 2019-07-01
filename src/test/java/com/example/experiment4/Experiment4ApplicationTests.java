package com.example.experiment4;

import com.example.experiment4.service.UserService;
import com.mysql.cj.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Experiment4ApplicationTests {
@Autowired
private UserService userService;
    @Test
    public void contextLoads() {
        userService.buyCar();
    }
    @Test
    public  void addUser(){
        userService.addUser();
    }

}
