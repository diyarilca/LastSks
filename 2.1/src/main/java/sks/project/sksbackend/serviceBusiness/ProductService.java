package sks.project.sksbackend.serviceBusiness;

import java.util.List;

import sks.project.sksbackend.entities.Product;

public interface ProductService {
	
	Product getProductById(Long productId);
	
	List<Product> getAllProduct();
	
	Product updateProduct(Long productId, Product updateProduct);
	
	void deleteProduct(Long productId);
	
	Product createProduct(Product product);
}
