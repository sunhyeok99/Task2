package com.example.Api.user.Controller;

import com.example.Api.user.Dto.UserDto;
import com.example.Api.user.Dto.UserListDto;
import com.example.Api.user.Entity.User;
import com.example.Api.user.Service.UserService;
import com.example.global.common.dto.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    // 사용자 수정 APi
    @PostMapping("/update/{id}")
    public SuccessResponse<?> userUpdate(@PathVariable Integer id) {
        userService.updateUser(id);
        return new SuccessResponse<>(HttpStatus.OK.value());
    }

    // 사용자 제거 APi
    @PostMapping("/delete/{id}")
    public SuccessResponse<?> userDelete(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new SuccessResponse<>(HttpStatus.OK.value());
    }

}