package com.project.service.impl;

import com.project.dto.OrderDTO;
import com.project.service.OrderService;
import com.project.dao.OrderDao;
import com.project.dao.impl.OrderDaoImplUsingJdbc;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImplUsingJdbc();
	
	@Override
	public boolean isOrderPlaced(OrderDTO order) {
		return orderDao.isOrderPlaced(order);
	}

	@Override
	public boolean isOrderCancelled(OrderDTO order) {
		return orderDao.isOrderCancelled(order);
	}

}
