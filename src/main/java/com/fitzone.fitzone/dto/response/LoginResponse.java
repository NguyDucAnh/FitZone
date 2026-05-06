package com.fitzone.fitzone.dto.response;

import com.fitzone.fitzone.entity.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {
    boolean login;
    UserEntity user;
    String message;
}
