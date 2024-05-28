package org.example.nghia.services;

import org.example.nghia.entities.User;
import org.example.nghia.repositories.UserRepository;
import org.example.nghia.requesEntities.RequesUpdateUser;
import org.example.nghia.requesEntities.RequesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll().stream().filter(user -> !user.isIsdeleted()).toList();
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Role with id " + id + " not found")
        );
    }

    public User createUser(RequesUser requesUser){
        try {
            User newUser= new User();
            newUser.setEmail(requesUser.getEmail());
            newUser.setPassword(requesUser.getPassword());
            newUser.setFirstname(requesUser.getFirstname());
            newUser.setLastname(requesUser.getLastname());
            newUser.setUsername(requesUser.getUsername());
            newUser.setIsdeleted(false);
            newUser.setRole(requesUser.getRole());
            userRepository.save(newUser);
            return newUser;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void updateUser(RequesUpdateUser requesUpdateUser,String id){
        try {

            User user= getUserById(id);
            user.setEmail(requesUpdateUser.getEmail());
            if(requesUpdateUser.getPassword()!=null)
                user.setPassword(requesUpdateUser.getPassword());
            user.setFirstname(requesUpdateUser.getFirstname());
            user.setLastname(requesUpdateUser.getLastname());
            user.setUsername(requesUpdateUser.getUsername());
            userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteUser(String id){
        try {
            User user= getUserById(id);
            user.setIsdeleted(true);
            userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
