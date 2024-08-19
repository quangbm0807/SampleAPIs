package com.quang.sampleapi.controller;

import com.quang.sampleapi.dto.request.UserRequestDTO;
import com.quang.sampleapi.dto.response.ResponseData;
import com.quang.sampleapi.dto.response.ResponseSuccess;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<UserRequestDTO> addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully", userDTO);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseData updateUser(@PathVariable("userId") int userID, @RequestBody UserRequestDTO userDTO) {
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
    }

    @PatchMapping("/{userId}")
    public ResponseData patchUser(@Min(1) @PathVariable("userId") int userID, @Min(1) @RequestParam int Status) {
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseData deleteUser(@PathVariable("userId") int userID) {
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted successfully");
    }

    @GetMapping("/{userId}")
    public ResponseData<UserRequestDTO> getUser(@PathVariable int userId) {
        return new ResponseData<>(HttpStatus.OK.value(), "User", new UserRequestDTO("Quang", "Bui", "0342868639", "buiminhquang2002@gmail.com"));
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<List<UserRequestDTO>> getUsers(@RequestParam(required = false) String email,
                                    @RequestParam(defaultValue = "0") int pageNo,
                                    @RequestParam(defaultValue = "10") int pageSize) {
        return new ResponseData<>(HttpStatus.OK.value(), "List Users", List.of(new UserRequestDTO("Quang", "Bui", "0342868639", "buiminhquang2002@gmail.com"),
                new UserRequestDTO("Uyen", "Nguyen", "0917504072", "nhdu181003@gmail.com")));
    }
}
