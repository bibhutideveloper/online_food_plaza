package com.project.service;

import com.project.dto.OrderDTO;

public interface OrderService {
	boolean isOrderPlaced(OrderDTO order);
	boolean isOrderCancelled(OrderDTO order);
}
