package com.project.service;

import java.util.List;

import com.project.dto.ProductDTO;

public interface ProductService {
	boolean saveProduct(ProductDTO product);
	boolean updateProduct(ProductDTO product);
	boolean deleteProduct(ProductDTO product);
//	ProductDTO searchProduct();
	ProductDTO searchProduct(String productName);
	List<ProductDTO> showAllProduct();
}
