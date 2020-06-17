package com.example.aptivist.aptivistapp.dto.mapper;

import com.example.aptivist.aptivistapp.dto.UserDto;
import com.example.aptivist.aptivistapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserMapper() {
    }

    public static UserDto toUserDto(User user) {
        UserDto uDto = new UserDto();
        uDto.setUserNameDto(user.getUserName());
        uDto.setPasswordDto(user.getPassword());
        return uDto;
    }
}
