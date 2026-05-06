package com.fitzone.fitzone.mapper;

import com.fitzone.fitzone.dto.request.ProductRequest;
import com.fitzone.fitzone.dto.response.ProductResponse;
import com.fitzone.fitzone.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toProductResponse(ProductEntity productEntity);
    ProductEntity toProductEntity(ProductRequest productRequest);
    void updateProductEntity(@MappingTarget ProductEntity productEntity, ProductRequest productRequest);
}
