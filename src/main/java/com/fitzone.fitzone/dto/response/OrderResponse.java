package com.fitzone.fitzone.dto.response;

import com.fitzone.fitzone.entity.OrderDetailEntity;
import com.fitzone.fitzone.entity.UserEntity;
import com.fitzone.fitzone.enums.StatusOrderEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
    Long id;
    Date date;
    Long total;
    Long quantity;
    String phone;
    String address;
    StatusOrderEnum status;
    UserEntity user;
    List<OrderDetailEntity> items;
}
