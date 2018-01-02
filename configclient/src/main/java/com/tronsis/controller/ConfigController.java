package com.tronsis.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Derrick on 2017/12/29.
 */
@RefreshScope
@RestController
public class ConfigController {

    @Value("${info.profile}")
    private String info;

    @GetMapping("info")
    public String info(){
        return info;
    }
}
