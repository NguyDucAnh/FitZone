package com.fitzone.fitzone.dto.response;


import com.fitzone.fitzone.entity.OrderEntity;
import com.fitzone.fitzone.entity.ProductEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailResponse {
    Long id;
    Long quantity;
    Long price;
    Long discount;
    Long total;
    OrderEntity order;
    ProductEntity product;
}
