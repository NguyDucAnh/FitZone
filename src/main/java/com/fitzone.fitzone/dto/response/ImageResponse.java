package com.fitzone.fitzone.dto.response;

import com.fitzone.fitzone.entity.ProductEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageResponse {
    Long id;
    String imageLink;
    ProductEntity product;
}


