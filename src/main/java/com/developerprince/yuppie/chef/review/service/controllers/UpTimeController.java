package com.developerprince.yuppie.chef.review.service.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/uptime")
public class UpTimeController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")//NOSONAR
    @GetMapping
    public String health() {
        return "ACK";
    }

}