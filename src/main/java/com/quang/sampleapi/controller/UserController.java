package com.quang.sampleapi.controller;

import com.quang.sampleapi.dto.request.UserRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public String addUser(@RequestBody UserRequestDTO userDTO) {

        return "success";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") int userID, @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request update user ID = "+userID);
        return "success updated user ID = "+userID;
    }

}
