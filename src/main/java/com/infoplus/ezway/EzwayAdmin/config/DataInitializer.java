package com.infoplus.ezway.EzwayAdmin.config;

import com.infoplus.ezway.EzwayAdmin.entity.Role;
import com.infoplus.ezway.EzwayAdmin.entity.UserEntity;
import com.infoplus.ezway.EzwayAdmin.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userMapper.countAllUsers() == 0) {
            UserEntity admin = UserEntity.builder()
                    .employeeId("st001")
                    .fullName("System Admin")
                    .email("admin@system.com")
                    .password(passwordEncoder.encode("admin123"))
                    .status("ACTIVE")
                    .pin(1234)
                    .role(Role.ADMIN)
                    .build();
            userMapper.insertNewUserV2(admin);
            System.out.println("⚡ Default SYSTEM user created: system / admin123");
        }
    }
}