package com.fitzone.fitzone.mapper;

import com.fitzone.fitzone.dto.response.OrderDetailResponse;
import com.fitzone.fitzone.entity.OrderDetailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetailResponse toOrderDetailResponse(OrderDetailEntity order);
}
