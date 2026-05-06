package com.fitzone.fitzone.mapper;

import com.fitzone.fitzone.dto.response.OrderResponse;
import com.fitzone.fitzone.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponse toOrderResponse(OrderEntity order);
}