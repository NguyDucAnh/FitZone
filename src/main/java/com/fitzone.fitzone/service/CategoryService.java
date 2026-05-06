package com.fitzone.fitzone.service;

import com.fitzone.fitzone.dto.request.CategoryRequest;
import com.fitzone.fitzone.dto.response.CategoryResponse;
import com.fitzone.fitzone.enums.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface CategoryService {

    Page<CategoryResponse> getAllCategoriesPaginated(
            int page, int size,
            String sortField, String sortDir,
            String name, StatusEnum status
    );

    CategoryResponse getCategoryById(Long categoryId);

    CategoryResponse createCategory(CategoryRequest categoryRequest,  MultipartFile file);

    CategoryResponse updateCategory(Long categoryId, CategoryRequest categoryRequest, MultipartFile file);

    void softDeleteCategory(Long categoryId);

    void restoreCategory(Long categoryId);

    void deleteCategory(Long categoryId);

    void updateImage(Long categoryId, String image);

    void deleteImage(Long categoryId);
}
