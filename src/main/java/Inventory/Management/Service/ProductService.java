package Inventory.Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import Inventory.Management.Entity.Product;
import Inventory.Management.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service

public class ProductService {
	private final ProductRepository productRepository;
    @Autowired
    public ProductService( ProductRepository productRepository) {
		this.productRepository = productRepository;

}



	@GetMapping
	public List<Product>  getProducts(){

	return productRepository.findAll();
	}




	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(productRepository, HttpStatus.OK);
	}


    public void addNewProduct(Product product) {
    }

	public void deleteProduct(Long productId) {

		productRepository.findById(productId);
		boolean exists=productRepository.existsById(productId);
				if(!exists){
					throw new IllegalStateException("product with id"+ productId +"does not exist");


				}
				productRepository.existsById(productId);
	}

	
}
