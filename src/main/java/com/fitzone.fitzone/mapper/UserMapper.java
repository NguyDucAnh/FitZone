package com.fitzone.fitzone.mapper;


import com.fitzone.fitzone.dto.request.CreateUserRequest;
import com.fitzone.fitzone.dto.request.UpdateUserRequest;
import com.fitzone.fitzone.dto.response.UserResponse;
import com.fitzone.fitzone.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(UserEntity userEntity);

    UserEntity toUserEntity(CreateUserRequest newUser);

    void updateUserEntity(@MappingTarget UserEntity userEntity, UpdateUserRequest updateUserRequest);
}
