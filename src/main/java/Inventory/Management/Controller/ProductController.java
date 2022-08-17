package Inventory.Management.Controller;


import Inventory.Management.Entity.Product;
import Inventory.Management.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RestController
@RequestMapping(path="api/v1/product")
public class ProductController {


    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
  public   List<Product>getProducts(){


return  productService.getProducts();

}
@PostMapping("/add")
public void registerNewProduct(@RequestBody  Product product){

        productService.addNewProduct(product);
}

@DeleteMapping(path="{productId}")

  public  void   deleteProduct(@PathVariable("productId")Long productId ){

productService.deleteProduct(productId);


}
@PutMapping(path ="{prouctId}" )
        public void   updateProduct(
                @PathVariable("productId") Long   productId,
                @RequestParam (required=false) String productName,
                @RequestParam (required=false) LocalDate date  ,
                @RequestParam (required=false) String productCode,
                @RequestParam (required=false) int reorderLevel,
                @RequestParam(required=false) int Quantity,
                @RequestParam(required = false)String Sensitivity)


{


            productService.updateProduct(productId,productName,date,productCode,reorderLevel,Quantity,Sensitivity);


    }





}











