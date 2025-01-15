package com.example.Api.user.Service;

import com.example.Api.user.Dto.UserDto;
import com.example.Api.user.Dto.UserListDto;
import com.example.Api.user.Entity.User;
import com.example.Api.user.Repository.UserRepository;
import com.example.global.common.exception.CustomException;
import com.example.global.common.exception.ErrorCode;
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
                        user.getUpda_user(),
                        user.getUpda_dt(),
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

    // 사용자 업데이트
    @Transactional
    public void updateUser(Integer id) {
        User user = userRepository.findById(Long.valueOf(id)).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND_ERROR1));
        if(user.getUse_yn().equals("N")){
            throw new CustomException(ErrorCode.USER_NOT_FOUND_ERROR1);
        }
        user.update();
    }

    // 사용자 제거
    @Transactional
    public void deleteUser(Integer id) {
        User user = userRepository.findById(Long.valueOf(id)).orElseThrow(() ->  new CustomException(ErrorCode.USER_NOT_FOUND_ERROR2));
        if(user.getUse_yn().equals("N")){
            throw new CustomException(ErrorCode.USER_NOT_FOUND_ERROR2);
        }
        user.delete();
    }

}
