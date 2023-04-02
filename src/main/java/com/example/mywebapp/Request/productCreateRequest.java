package com.example.mywebapp.Request;

import com.example.mywebapp.Entities.product;
import lombok.Data;

@Data
public class productCreateRequest {

    int product_id;
    String product_name;
    int offer;
    int user_id;



}
