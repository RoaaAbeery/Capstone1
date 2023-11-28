package com.example.newcapstone.Service;

import com.example.newcapstone.Model.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    private final MerchantService merchantService;
    private final ProductService productService;
    private final UserService userService;

    ArrayList<MerchantStock> merchantStocks=new ArrayList<>();
    public ArrayList getMerchantStocks(){
        return merchantStocks;
    }
    public int addMerchantStocks(MerchantStock merchantStock) {
        for (int i = 0; i < merchantService.merchants.size(); i++) {
            if (merchantStock.getMerchantid().equals(merchantService.merchants.get(i).getId())) {
                for (int j = 0; j < productService.products.size(); j++) {
                    if (merchantStock.getProductid().equals(productService.products.get(j).getId())) {
                        merchantStocks.add(merchantStock);
                        return 0;
                    }
                } return 1;//pid
            }
        } return 2;//mid
    }

    public int updateMerchantStocks(String id , MerchantStock merchantStock){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId().equals(id)) {
                for (int j = 0; j < merchantService.merchants.size(); j++) {
                    if(merchantStock.getMerchantid().equals(merchantService.merchants.get(i).getId())){
                        for (int l = 0; l <productService.products.size() ; l++){
                            if(merchantStock.getMerchantid().equals(productService.products.get(i).getId())){
                                merchantStocks.set(i,merchantStock);
                                return 0;
                            }
                        } return 1;
                    }
                } return 2 ;//mid

            }
        } return 3;//sid

    }
    public boolean deleteMerchantStocks(String id){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId().equals(id)){
                merchantStocks.remove(i);
                return true;
            }

        }
        return false;
    }

public int addstock(String productid ,String merchantid , int amount) {
    for (int j = 0; j < productService.products.size(); j++) {
        if (productService.products.get(j).getId().equals(productid)) {
            for (int k = 0; k < merchantService.merchants.size(); k++) {
                if (merchantService.merchants.get(k).getId().equals(merchantid)) {
                    for (int i = 0; i < merchantStocks.size(); i++) {
                    merchantStocks.get(i).setStock(merchantStocks.get(i).getStock() + amount);
                }return 0;
            }
        }return 1;//m
    }
}return 2;//p
    }

public int buy1(String userid,String productid,String merchantid) {
    for (int i = 0; i < userService.users.size(); i++) {
        if (userService.users.get(i).getId().equals(userid)) {
            for (int j = 0; j < productService.products.size(); j++) {
                if (productService.products.get(j).getId().equals(productid)) {
                    for (int k = 0; k < merchantService.merchants.size(); k++) {
                        if (merchantService.merchants.get(k).getId().equals(merchantid)) {
                            for (int l = 0; l < merchantStocks.size(); l++) {
                                if(merchantStocks.get(i).getStock()>0){
                                    merchantStocks.get(i).setStock(merchantStocks.get(i).getStock()-1);
                                    if(userService.users.get(i).getBalance()<productService.products.get(j).getPrice()){
                                        return 0;
                                        }// balan
                                    else userService.users.get(j).setBalance(userService.users.get(j).getBalance()-productService.products.get(i).getPrice());
                                    return 1;//good
                        }


                    }return 2;//sid

                } return 3;//mid

            }return 4;//pid

        }

    }
}

}return 5;//uid
    }



}

