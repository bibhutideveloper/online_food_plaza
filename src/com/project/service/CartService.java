package com.project.service;

import com.project.dto.CartDTO;

public interface CartService {
	boolean isAddedToCart(CartDTO cart);
	boolean isDeletedFromCart(CartDTO cart);
}
