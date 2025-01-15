package com.example.Api.user.Controller;

import com.example.Api.user.Dto.UserDto;
import com.example.Api.user.Dto.UserListDto;
import com.example.Api.user.Entity.User;
import com.example.Api.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bi/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 사용자 조회 API
    @GetMapping("/table")
    public List<UserListDto> getAllUsers() {
        return userService.getAllUsers();
    }

    // 사용자 등록 API
    @PostMapping("/regiUser")
    public User registerUser(@RequestBody UserDto userDtO) {
        return userService.registerUser(userDtO);
    }
}