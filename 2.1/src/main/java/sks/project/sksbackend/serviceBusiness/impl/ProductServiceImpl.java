package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.entities.Product;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.repositoryDataAccess.ProductRepository;
import sks.project.sksbackend.serviceBusiness.ProductService;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;


    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip ürün mevcut değil " + productId));
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long productId, Product updateProduct) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip ürün mevcut değil " + productId));

        product.setProductName(updateProduct.getProductName());
        // Burada diğer özelliklerin güncellenmesi yapılabilir

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip ürün mevcut değil " + productId));

        productRepository.delete(product);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
	
	

}
