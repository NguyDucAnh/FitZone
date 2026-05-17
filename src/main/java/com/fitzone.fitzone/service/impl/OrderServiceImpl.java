package com.fitzone.fitzone.service.impl;

import com.fitzone.fitzone.dto.response.DailyRevenue;
import com.fitzone.fitzone.dto.response.OrderResponse;
import com.fitzone.fitzone.entity.OrderDetailEntity;
import com.fitzone.fitzone.entity.OrderEntity;
import com.fitzone.fitzone.entity.UserEntity;
import com.fitzone.fitzone.enums.StatusOrderEnum;
import com.fitzone.fitzone.mapper.OrderMapper;
import com.fitzone.fitzone.repository.OrderDetailRepository;
import com.fitzone.fitzone.repository.OrderRepository;
import com.fitzone.fitzone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Long getCount(){
        return orderRepository.count();
    }

    @Override
    public Long getIncrease(){
        return orderRepository.findAll()
                       .stream()
                       .mapToLong(order -> order.getTotal())
                       .sum();
    }

    @Override
    public List<OrderResponse> getAllOrder() {
        List<OrderResponse> result = new ArrayList<>();

        for(OrderEntity order : orderRepository.findAll()){
            result.add(orderMapper.toOrderResponse(order));
        }
        return result;
    }

    @Override
    public OrderResponse getOrderById(Long orderId) {
        return orderMapper.toOrderResponse(orderRepository.findById(orderId).get());
    }

    @Override
    public Long AddOrder(UserEntity user) {

        OrderEntity order = new OrderEntity();

        order.setDate(new Date());
        order.setUser(user);

        orderRepository.save(order);

        return  order.getId();
    }

    @Override
    public void UpdateToTalPrice(Long orderId) {
        Long totalPrice = 0L;
        List<OrderDetailEntity> orderDetails = orderDetailRepository.findByOrderId(orderId);
        for(OrderDetailEntity item : orderDetails){
            totalPrice += item.getTotal();
        }

        OrderEntity order = orderRepository.findById(orderId).get();

        order.setTotal(totalPrice);
        order.setQuantity(Long.valueOf(orderDetails.size()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderResponse> historyBuy(Long userId) {
        List<OrderResponse> result = new ArrayList<>();

        for(OrderEntity order : orderRepository.findByUserId(userId)){
            result.add(orderMapper.toOrderResponse(order));
        }
        return result;
    }

    @Override
    public void updateStatusOrder(Long orderId, StatusOrderEnum status){
        OrderEntity order = orderRepository.findById(orderId).get();

        order.setStatus(status);

        orderRepository.save(order);
    }

    @Override
    public List<DailyRevenue> getRevenueByDay(LocalDate startDate, LocalDate endDate) {
        // Chuyển đổi LocalDate sang LocalDateTime
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);

        List<Object[]> rawData = orderRepository.findRevenueByDay(startDateTime, endDateTime);
        List<DailyRevenue> dailyRevenues = new ArrayList<>();

        for (Object[] row : rawData) {
            String date = ((Date) row[0]).toString();
            BigDecimal revenue = (BigDecimal) row[1];
            dailyRevenues.add(new DailyRevenue(date, revenue));
        }

        return dailyRevenues;
    }
}
