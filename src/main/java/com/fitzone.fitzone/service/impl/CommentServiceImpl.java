package com.fitzone.fitzone.service.impl;

import com.fitzone.fitzone.entity.CommentEntity;
import com.fitzone.fitzone.enums.StatusEnum;
import com.fitzone.fitzone.repository.CommentRepository;
import com.fitzone.fitzone.repository.ProductRepository;
import com.fitzone.fitzone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CommentEntity> findByProductId(Long productId) {
        return commentRepository.findByProductId(productId);
    }

    @Override
    public void AddComment(CommentEntity newComment, Long productId) {

        newComment.setCreateDate(new Date());
        newComment.setProduct(productRepository.findByIdAndStatus(productId, StatusEnum.Active));
        commentRepository.save(newComment);

    }
}
