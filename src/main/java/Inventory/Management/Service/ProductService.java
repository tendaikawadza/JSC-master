package Inventory.Management.Service;

import Inventory.Management.Entity.Product;
import Inventory.Management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    private  final ProductRepository productRepository;
     @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getProducts() {

        return productRepository.findAll();

    }

    public void addNewProduct(Product product) {
        productRepository.save(product);
    }


    public void deleteProduct(Long productId) {

         boolean exists= productRepository.existsById(productId);
         if(!exists){
                 throw new IllegalStateException("product with id "+ productId+"does  not exists" );



         }

         productRepository.deleteById(productId);

    }

    @Transactional
    public void updateProduct(Long productId,
                              String productName,
                              LocalDate date, String productCode,

                              int reorderLevel,
                              int Quantity,

                              String Sensitivity

                                  ){

           Product product=productRepository.findById(productId)
                   .orElseThrow(()->new  IllegalStateException(
                         "product  with id  " + productId+"does not exist"));
                    if(productName != null&&
                                 productName.length()>0  &&
                                          !Objects.equals(product.getProductName(),productName)){
                                       product.setProductName(productName);
        }

    }
}
