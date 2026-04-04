package com.khanhvu.booking_system.dto.request;

import com.khanhvu.booking_system.validator.DobConstraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserCreationRequest {
    String id;

    @Size(min = 3, message = "USERNAME_INVALID")
    private String username;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;
    String firstName;
    String lastName;

    @DobConstraint(min = 18,message = "INVALID_DOB")
    LocalDate dob;
}
