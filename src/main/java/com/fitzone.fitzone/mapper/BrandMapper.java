package com.fitzone.fitzone.mapper;

import com.fitzone.fitzone.dto.request.BrandRequest;
import com.fitzone.fitzone.dto.response.BrandResponse;
import com.fitzone.fitzone.entity.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandResponse toBrandResponse(BrandEntity brandEntity);

    BrandEntity toEntity(BrandRequest brandRequest);
}
