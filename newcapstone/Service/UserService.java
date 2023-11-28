package com.example.newcapstone.Service;

import com.example.newcapstone.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    ArrayList<User> users=new ArrayList<>();
    public ArrayList<User> getUsers (){
        return users;
    }
    public void addUsers(User user){
        users.add(user);
    }
    public boolean updateUsers(String id ,User user){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                users.set(i,user);
                return true;
            }

        }
        return false;
    }
    public boolean deleteUsers(String id ){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                users.remove(i);
                return true;
            }

        }
        return false;
    }
}
