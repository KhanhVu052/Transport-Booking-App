package com.khanhvu.booking_system.configuration;

import com.khanhvu.booking_system.entity.User;
import com.khanhvu.booking_system.entity.Role; // Đảm bảo import đúng Entity Role
import com.khanhvu.booking_system.repository.RoleRepository; // Inject thêm repository này
import com.khanhvu.booking_system.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {

                var adminRole = roleRepository.save(com.khanhvu.booking_system.entity.Role.builder()
                        .name("ADMIN")
                        .description("Administrator role")
                        .build());


                var roles = new HashSet<com.khanhvu.booking_system.entity.Role>();
                roles.add(adminRole);


                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles(roles)
                        .build();

                userRepository.save(user);
                log.warn("Admin user has been created with default password: admin");
            }
        };
    }
}