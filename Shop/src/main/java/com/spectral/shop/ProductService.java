package com.spectral.shop;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public int getCountPages(int limit) {
    	return (int) Math.ceil(((int) productRepository.count())*1.0/limit);
    }
    
    public List<Product> getProducts() {
    	return productRepository.findAll();
    }
    
    public Product find (int id)
    {
    	return productRepository.findById(id).get();
    }
    public void add(Product product)
    {   
    	

    	productRepository.save(product);
    	
    	
    }
    public void edit (Product product, int id)
    {
        Product tmpProduct = productRepository.getOne(id);
        tmpProduct.setName(product.getName());
        tmpProduct.setDescription(product.getDescription());
        tmpProduct.setPrice(product.getPrice());
        tmpProduct.setPic(product.getPic());
        productRepository.save(tmpProduct);
    }
    

    
    public void delete (int id)
    {
    	productRepository.deleteById(id);
    }
    
}
