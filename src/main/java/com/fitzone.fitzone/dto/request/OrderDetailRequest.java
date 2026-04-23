package com.fitzone.fitzone.dto.request;

import com.fitzone.fitzone.entity.OrderEntity;
import com.fitzone.fitzone.entity.ProductEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailRequest {
    Long id;
    Long quantity;
    OrderEntity order;
    ProductEntity product;
}
