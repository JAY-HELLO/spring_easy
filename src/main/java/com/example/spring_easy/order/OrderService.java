package com.example.spring_easy.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
