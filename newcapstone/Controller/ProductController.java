package com.example.newcapstone.Controller;

import com.example.newcapstone.Model.Product;
import com.example.newcapstone.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity getProducts(){
        ArrayList products=productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    @PostMapping("/addProducts")
    public ResponseEntity addProducts(@Valid @RequestBody Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean add=productService.addProducts(product);
        if(add){
            return ResponseEntity.status(HttpStatus.OK).body("product add");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("product Not found");

    }
    @PutMapping("/updateProducts/{id}")
    public ResponseEntity updateMerchantStocks(@PathVariable String id, @Valid @RequestBody Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isupdate=productService.updateProduct(id, product);
        if(isupdate){
            return ResponseEntity.status(HttpStatus.OK).body("product updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("product Not found");
    }

    @DeleteMapping("/deleteProducts/{id}")
    public ResponseEntity deleteMerchantStocks(@PathVariable String id){
        boolean isDelete= productService.deleteProduct(id);
        if (isDelete){
            return ResponseEntity.status(HttpStatus.OK).body("product Deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("product not found");
    }
    @PutMapping("/discountProducts/{id}")
    public ResponseEntity discount(@PathVariable String id){

        boolean isupdate=productService.discount(id);
        if(isupdate){
            return ResponseEntity.status(HttpStatus.OK).body("Discounted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("product Not found");
    }
}
