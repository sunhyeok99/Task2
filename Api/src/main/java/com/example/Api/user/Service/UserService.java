package com.example.Api.user.Service;

import com.example.Api.user.Dto.UserDto;
import com.example.Api.user.Dto.UserListDto;
import com.example.Api.user.Entity.User;
import com.example.Api.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 모든 사용자 조회
    public List<UserListDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        // 엔티티를 DTO로 변환
        return users.stream()
                .map(user -> new UserListDto(
                        user.getId(),
                        user.getUser_nm(),
                        user.getUser_id(),
                        user.getPw(),
                        user.getRegi_dt(),
                        user.getRegi_user(),
                        user.getUse_yn()
                ))
                .collect(Collectors.toList());
    }

    // 사용자 등록
    @Transactional
    public User registerUser(UserDto userDTO) {
        // DTO를 엔티티로 변환
        User user = new User(
                userDTO.getUserNm(),
                userDTO.getUserId(),
                userDTO.getPw(),
                new Date(),  // 현재 시간으로 등록일 설정
                userDTO.getRegiUser(),
                "Y"
        );
        // DB에 저장
        return userRepository.save(user);
    }
}
