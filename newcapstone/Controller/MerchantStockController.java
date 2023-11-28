package com.example.newcapstone.Controller;

import com.example.newcapstone.Model.MerchantStock;
import com.example.newcapstone.Service.MerchantService;
import com.example.newcapstone.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/MerchantStock")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;
    @GetMapping("/getMerchantStocks")
    public ResponseEntity getMerchantStocks(){
        ArrayList merchantStocks=merchantStockService.getMerchantStocks();
        return ResponseEntity.status(HttpStatus.OK).body(merchantStocks);
    }

    @PostMapping("/addMerchantStocks")
    public ResponseEntity addMerchantStocks(@Valid @RequestBody MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        int add=merchantStockService.addMerchantStocks(merchantStock);
        switch (add){
            case 1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("product id must be equal");
            case 2:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Merchant id must be equal");
            default:
                return ResponseEntity.status(HttpStatus.OK).body("product add");
        }
    }

    @PutMapping("/updateMerchantStocks/{id}")
    public ResponseEntity updateMerchantStocks(@PathVariable String id,@Valid @RequestBody MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        int isupdate=merchantStockService.updateMerchantStocks(id,merchantStock);
        switch (isupdate){
            case 1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("product id must be equal");
            case 2:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Merchant id must be equal");
            case 3:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stock id must be equal");

            default:
                return ResponseEntity.status(HttpStatus.OK).body("product add");
        }
    }

    @DeleteMapping("/deleteMerchantStocks/{id}")
    public ResponseEntity deleteMerchantStocks(@PathVariable String id){
        boolean isDelete= merchantStockService.deleteMerchantStocks(id);
        if (isDelete){
            return ResponseEntity.status(HttpStatus.OK).body("Merchant Stock Deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Merchant Stock not found");
    }
    @PutMapping("/addStock/{productid}/{merchantid}/{amount}")
    public ResponseEntity addStock(@PathVariable String productid ,@PathVariable String merchantid ,@PathVariable int amount){
         boolean isadd=merchantStockService.addstock(productid, merchantid, amount);
         if(isadd){
             return ResponseEntity.status(HttpStatus.OK).body("Stock has been increased");
         }
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
    }
    @PutMapping("/buy/{userid}/{productid}/{merchantid}")
    public ResponseEntity buy(@PathVariable String userid,@PathVariable String productid ,@PathVariable String merchantid ){
        boolean isadd=merchantStockService.buy(userid, productid, merchantid);

        if(isadd){
            return ResponseEntity.status(HttpStatus.OK).body("Buying succeeded");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id not found");
    }
}
