package com.example.mywebapp.Controller;
import com.example.mywebapp.Entities.product;
import com.example.mywebapp.services.productService;
import org.springframework.web.bind.annotation.*;
import com.example.mywebapp.Request.productCreateRequest;
import com.example.mywebapp.Request.ProductUpdateRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")

public class productController {
    private  productService productSercive;


    public productController(productService productSercive) {
        this.productSercive = productSercive;
    }

    @GetMapping
    public List<product>getAllProducts(@RequestParam Optional<Integer> user_id){

        return productSercive.getAllProduct(user_id);

    }


    @PostMapping
    public product creatOneProduct(@RequestBody productCreateRequest newProductRequest){
        return productSercive.creaatOneProduct(newProductRequest);
    }

    @GetMapping("/product_id")
    public product getOneProduct(@PathVariable  int product_id){
        return productSercive.getOneProductById(product_id);
    }

    @PutMapping("/post_id")
    public product updateOneProduct(@PathVariable int product_id,@RequestBody ProductUpdateRequest updateProduct){

        return productSercive.updateOneProductById(product_id,updateProduct);
    }
    @DeleteMapping("/product_id")
    public void deleteOneProduct(@PathVariable int product_id){
        productSercive.deleteOneProductById(product_id);
    }


}
