package com.fitzone.fitzone.mapper;

import com.fitzone.fitzone.dto.response.ImageResponse;
import com.fitzone.fitzone.entity.ImageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageResponse toImageResponse(ImageEntity imageEntity);
}
