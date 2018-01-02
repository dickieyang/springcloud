package com.tronsis.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eureka-client")
public interface DcClient {

    @RequestMapping(value = "/dc",method = RequestMethod.GET)
    String consumer();

}