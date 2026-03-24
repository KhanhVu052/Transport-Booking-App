package com.khanhvu.booking_system.mapper;

import com.khanhvu.booking_system.dto.request.PermissionRequest;
import com.khanhvu.booking_system.dto.request.RoleRequest;
import com.khanhvu.booking_system.dto.respone.PermissionResponse;
import com.khanhvu.booking_system.dto.respone.RoleResponse;
import com.khanhvu.booking_system.entity.Permission;
import com.khanhvu.booking_system.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
