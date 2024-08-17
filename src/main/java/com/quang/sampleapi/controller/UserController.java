package com.quang.sampleapi.controller;

import com.quang.sampleapi.dto.request.UserRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public String addUser(@RequestBody UserRequestDTO userDTO) {

        return "success";
    }

}
