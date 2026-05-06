package com.fitzone.fitzone.dto.response;

import com.fitzone.fitzone.entity.BrandEntity;
import com.fitzone.fitzone.entity.CategoryEntity;
import com.fitzone.fitzone.entity.ImageEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Long id;
    String name;
    Long price;
    Long discount;
    String description;
    String color;
    Long quantity;
    Date createDate;
    Date updateDate;
    CategoryEntity category;
    BrandEntity brand;
    List<ImageEntity> images;
}
