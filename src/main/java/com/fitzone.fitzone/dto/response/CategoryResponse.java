package com.fitzone.fitzone.dto.response;

import com.fitzone.fitzone.entity.ProductEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse {
    Long id;
    String name;
    String image;
    List<ProductEntity> products;
}
