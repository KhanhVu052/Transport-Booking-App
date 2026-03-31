package com.khanhvu.booking_system.dto.respone;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Set;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String firstName;
    String lastName;
    LocalDate dob;


    Set<RoleResponse> roles;

}
