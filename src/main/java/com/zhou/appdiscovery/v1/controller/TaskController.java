package com.zhou.appdiscovery.v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("TaskControllerV1")
@RequestMapping("/v1/")
public class TaskController {

    @RequestMapping(value="hello", method= RequestMethod.GET)
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("world", HttpStatus.OK);
    }
}
