package com.example.newcapstone.Service;

import com.example.newcapstone.Model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductService {
private final CategoryService categoryService;
    ArrayList<Product> products=new ArrayList<>();
    public ArrayList<Product> getProducts(){
        return products;
    }
    public boolean addProducts( Product product){
        for (int i = 0; i < categoryService.categories.size(); i++) {
            if(product.getCategoryID().equals(categoryService.categories.get(i).getId())){
                products.add(product);
            return true;
            }
        }
        return false;
    }
    public boolean updateProduct (String id ,Product product){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId().equals(id)) {
                for (int j = 0; j < categoryService.categories.size(); j++) {
                    if (product.getCategoryID().equals(categoryService.categories.get(j).getId())) {
                        products.set(i, product);
                        return true;
                    }
                }
            }}
        return false;
    }

    public boolean deleteProduct(String id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId().equals(id)){
                products.remove(i);
                return true;
            }

        }
        return false;
    }
    public boolean discount(String id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId().equals(id)) {
                if (products.get(i).getDiscounts().equals("WhiteFriday")) {
                    products.get(i).setPrice(products.get(i).getPrice() * 0.3);
                    return true;
                }
            }
        }
        return false;
    }

}
