package com.pluralsight.store;

import com.pluralsight.abstracts.OrderItem;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private List<OrderItem> orderItems;
    private String customerName;
    private LocalDateTime orderTime;

}
