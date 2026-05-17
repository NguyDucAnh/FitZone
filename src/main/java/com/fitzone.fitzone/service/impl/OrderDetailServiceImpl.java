package com.fitzone.fitzone.service.impl;

import com.fitzone.fitzone.dto.response.OrderDetailResponse;
import com.fitzone.fitzone.entity.CartEntity;
import com.fitzone.fitzone.entity.OrderDetailEntity;
import com.fitzone.fitzone.entity.OrderEntity;
import com.fitzone.fitzone.entity.ProductEntity;
import com.fitzone.fitzone.mapper.OrderDetailMapper;
import com.fitzone.fitzone.repository.OrderDetailRepository;
import com.fitzone.fitzone.repository.OrderRepository;
import com.fitzone.fitzone.repository.ProductRepository;
import com.fitzone.fitzone.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public void AddItem(List<CartEntity> carts, Long orderId) {

        for(CartEntity cart : carts){
            OrderDetailEntity newItem = new OrderDetailEntity();

            ProductEntity product = productRepository.findById(cart.getProduct().getId()).get();

            OrderEntity order = orderRepository.findById(orderId).get();

            newItem.setQuantity(cart.getQuantity());
            newItem.setDiscount(product.getDiscount());
            newItem.setPrice(product.getPrice());
            newItem.setTotal((product.getPrice() * (100 - product.getDiscount()) / 100) * cart.getQuantity());
            newItem.setProduct(product);
            newItem.setOrder(order);

            orderDetailRepository.save(newItem);
        }

    }

    @Override
    public List<OrderDetailResponse> getItemByOrderId(Long orderId) {
        List<OrderDetailResponse> result = new ArrayList<>();

        for (OrderDetailEntity detail : orderDetailRepository.findByOrderId(orderId)){
            result.add(orderDetailMapper.toOrderDetailResponse(detail));
        }
        return result;
    }
}
