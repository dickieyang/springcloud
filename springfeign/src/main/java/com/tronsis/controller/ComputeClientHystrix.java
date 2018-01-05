package com.tronsis.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ComputeClientHystrix implements DcClient {


    @Override
    public String consumer() {
        return "error ~~~";
    }
}