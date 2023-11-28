package com.example.newcapstone.Controller;

import com.example.newcapstone.Model.Category;
import com.example.newcapstone.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/get")
    public ResponseEntity getCatorgies(){
        ArrayList catogries=categoryService.getCategories();
        return ResponseEntity.status(HttpStatus.OK).body(catogries);
    }
    @PostMapping("/add")
    public ResponseEntity addCatogries1(@Valid @RequestBody Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        categoryService.addCategories(category);
        return ResponseEntity.status(HttpStatus.OK).body("Category add");
    }
    @PutMapping("/updateCatogries")
    public ResponseEntity updateCatogries(@PathVariable String id,@Valid@RequestBody Category category, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated=categoryService.updateCategories(id, category);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body("Category update");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category not found");
    }
    @DeleteMapping("/deleteCatogries")
    public ResponseEntity delteCatogries(@PathVariable String id){
        boolean isDeleted=categoryService.deleteCategories(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("Category deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category not found");
    }
}
