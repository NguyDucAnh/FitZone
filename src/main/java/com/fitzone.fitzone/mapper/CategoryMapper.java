package com.fitzone.fitzone.mapper;

import com.fitzone.fitzone.dto.request.CategoryRequest;
import com.fitzone.fitzone.dto.response.CategoryResponse;
import com.fitzone.fitzone.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toCategoryResponse(CategoryEntity category);

    CategoryEntity toEntity(CategoryRequest categoryRequest);
}
