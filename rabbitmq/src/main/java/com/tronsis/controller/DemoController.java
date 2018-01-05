package com.tronsis.controller;

//import com.tronsis.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Created by Derrick on 2018/1/3.
 */


@RestController
public class DemoController {

    @Autowired
    private Sender sender;

    @GetMapping("/send")
    public String send(){
        sender.send("hello ");
        return "success";
    }

    /*@GetMapping("/sendReceive")
    public String sendAndReceive(){
        sender.send();
        return "success";
    }*/
}
