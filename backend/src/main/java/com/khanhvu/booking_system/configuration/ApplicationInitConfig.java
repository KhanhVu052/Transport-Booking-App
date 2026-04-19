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
                // 1. Tạo hoặc lấy Role ADMIN từ Database
                // Lưu ý: Nếu báo lỗi chưa có RoleRepository thì bạn nhớ @Autowired nó ở trên nhé
                var adminRole = roleRepository.save(com.khanhvu.booking_system.entity.Role.builder()
                        .name("ADMIN")
                        .description("Administrator role")
                        .build());

                // 2. Gán Role vào một Set (Entity Role chứ không phải String)
                var roles = new HashSet<com.khanhvu.booking_system.entity.Role>();
                roles.add(adminRole);

                // 3. Tạo User Admin có Role
                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles(roles) // Chỗ này hết lỗi gạch đỏ rồi nhé!
                        .build();

                userRepository.save(user);
                log.warn("Admin user has been created with default password: admin");
            }
        };
    }
}