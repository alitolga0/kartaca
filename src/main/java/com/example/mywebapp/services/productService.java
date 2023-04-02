package com.example.mywebapp.services;

import com.example.mywebapp.Entities.product;
import com.example.mywebapp.Request.productCreateRequest;
import com.example.mywebapp.dataAcces.productDao;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.mywebapp.Entities.users;
import com.example.mywebapp.services.userService;
import com.example.mywebapp.Request.ProductUpdateRequest;

import java.util.List;
import java.util.Optional;

@Service
public class productService {
    private productDao productDao;
    private userService userService;

    public productService(productDao productDao, userService userService) {
        this.productDao = productDao;
        this.userService = userService;
    }

    public List<product> getAllProduct(@RequestParam Optional<Integer> user_id) {

        if (user_id.isPresent()) {
            return productDao.findByUserId(user_id.get());

        } else {
            return productDao.findAll();

        }

    }

    public product getOneProductById(int product_id) {
        return productDao.findById(product_id).orElse(null);

    }

    public product creaatOneProduct(productCreateRequest newProductRequest) {
        users users = userService.getOneUser(newProductRequest.getUser_id());
        if (users == null) {

            product toSave = new product();
            toSave.setProduct_id(newProductRequest.getProduct_id());
            toSave.setProduct_name(newProductRequest.getProduct_name());
            toSave.setOffer(newProductRequest.getOffer());
            toSave.setUser_id(users.getUser_id());

            return productDao.save(toSave);
        } else {
            return null;
        }

    }

    public product updateOneProductById(int product_id, ProductUpdateRequest updateProduct) {

        Optional<product> product = productDao.findById(product_id);
        if (product.isPresent()) {
            product toUpdate = product.get();
            toUpdate.setProduct_name(updateProduct.getProduct_name());
            toUpdate.setOffer(updateProduct.getOffer());

            productDao.save(toUpdate);
            return toUpdate;



        }
        return null;
    }

    public void deleteOneProductById(int product_id) {
        productDao.deleteById(product_id);
    }
}
