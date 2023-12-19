package com.project.dao;

import com.project.dto.OrderDTO;

public interface OrderDao {
	boolean isOrderPlaced(OrderDTO order);
	boolean isOrderCancelled(OrderDTO order);
}
