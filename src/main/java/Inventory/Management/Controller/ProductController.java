 package Inventory.Management.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Inventory.Management.Entity.Product;
import Inventory.Management.Service.ProductService;
@RestController
@RequestMapping(path ="api/v1/product")
public class ProductController {

	@Autowired
	private final ProductService  productService;

	public ProductController(ProductService productService) {

		this.productService=  productService;
	}


	@GetMapping
	public List<Product>  getProducts(){
		return  productService.getProducts();
	}

    @PostMapping
  public void registerNewProduct(@RequestBody Product product){

		productService.addNewProduct(product);


  }



@DeleteMapping(path="{productId}")
public void deleteStudent(@PathVariable("productId")Long id){
		productService.deleteProduct(id );




}





  @GetMapping("/find/{id}")
	public ResponseEntity<Product>getProductById(@PathVariable("id")Long id){
		ResponseEntity<Object> products=productService.getProduct( );
		return new ResponseEntity<Product>(HttpStatus.OK);
	}







}
		
		
		
	
	
	
	


