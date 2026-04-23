package com.fitzone.fitzone.config;

import com.fitzone.fitzone.entity.UserEntity;
import com.fitzone.fitzone.enums.RoleEnum;
import com.fitzone.fitzone.enums.StatusEnum;
//import com.fitzone.fitzone.repository.BrandRepository;
//import com.fitzone.fitzone.repository.CategoryRepository;
import com.fitzone.fitzone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationInitConfig {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByUsername("admin") == null) {

                UserEntity user = UserEntity.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles(RoleEnum.ADMIN)
                        .status(StatusEnum.Active)
                        .build();
                userRepository.save(user);
            }
        };
    }
}


