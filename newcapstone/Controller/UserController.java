package com.example.newcapstone.Controller;

import com.example.newcapstone.Model.User;
import com.example.newcapstone.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api1/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity getUsers(){
        ArrayList users=userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @PostMapping("/addUsers")
    public ResponseEntity addUsers(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        userService.addUsers(user);
        return ResponseEntity.status(HttpStatus.OK).body("user add");
    }
    @PutMapping("/updateUsers/{id}")
    public ResponseEntity updateUserss(@PathVariable String id,@Valid@RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated=userService.updateUsers(id, user);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body("User updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
    }
    @DeleteMapping("/deleteUsers/{id}")
    public ResponseEntity delteUsers(@PathVariable String id){
        boolean isDeleted=userService.deleteUsers(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("User deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
    }

}
