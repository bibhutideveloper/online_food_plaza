package com.project.service.impl;

import com.project.dto.CartDTO;
import com.project.service.CartService;
import com.project.dao.CartDao;
import com.project.dao.impl.CartDaoImplUsingJdbc;

public class CartServiceImpl implements CartService {

	CartDao cartDao = new CartDaoImplUsingJdbc();
	
	@Override
	public boolean isAddedToCart(CartDTO cart) {
		return cartDao.isAddedtoCart(cart);
	}

	@Override
	public boolean isDeletedFromCart(CartDTO cart) {
		return cartDao.isDeletedFromCart(cart);
	}

}
