package com.khanhvu.booking_system.mapper;

import com.khanhvu.booking_system.dto.request.UserCreationRequest;

import com.khanhvu.booking_system.dto.request.UserUpdateRequest;
import com.khanhvu.booking_system.dto.respone.UserResponse;
import com.khanhvu.booking_system.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

}
