package com.quang.sampleapi.controller;

import com.quang.sampleapi.dto.request.UserRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public String addUser(@Valid @RequestBody UserRequestDTO userDTO) {

        return "success";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") int userID, @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request update user ID = " + userID);
        return "success updated user ID = " + userID;
    }

    @PatchMapping("/{userId}")
    public String patchUser(@Min(1) @PathVariable("userId") int userID, @Min(1) @RequestParam int Status) {
        System.out.println("Request update user status where = " + userID);
        return "success updated status of user ID = " + userID;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") int userID) {
        System.out.println("Request delete user ID = " + userID);
        return "success deleted user ID = " + userID;
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        System.out.println("Get user ID = " + userId);
        return new UserRequestDTO("Quang", "Bui", "0342868639", "buiminhquang2002@gmail.com");
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getUsers(@RequestParam(required = false) String email,
                                         @RequestParam(defaultValue = "0") int pageNo,
                                         @RequestParam(defaultValue = "10") int pageSize) {
        System.out.println("Get users");
        return List.of(new UserRequestDTO("Quang", "Bui", "0342868639", "buiminhquang2002@gmail.com"),
                new UserRequestDTO("Uyen", "Nguyen", "0917504072", "nhdu181003@gmail.com"));

    }
}
