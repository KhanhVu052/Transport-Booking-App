package com.khanhvu.booking_system.mapper;

import com.khanhvu.booking_system.dto.request.PermissionRequest;
import com.khanhvu.booking_system.dto.request.UserCreationRequest;
import com.khanhvu.booking_system.dto.request.UserUpdateRequest;
import com.khanhvu.booking_system.dto.respone.PermissionResponse;
import com.khanhvu.booking_system.dto.respone.UserResponse;
import com.khanhvu.booking_system.entity.Permission;
import com.khanhvu.booking_system.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
