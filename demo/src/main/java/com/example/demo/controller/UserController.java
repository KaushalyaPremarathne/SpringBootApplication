package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }
    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }

    @GetMapping("/getUserById/{userID}")
    public UserDTO getUserByID(@PathVariable String userID){
        return userService.getUserByID(userID);
    }

    @GetMapping("/getUserByIDAndAddress/{userID}/{address}")
    public UserDTO getUserByIDAndAddress(@PathVariable String userID, @PathVariable String address){
        System.out.println("UserID : " + userID + "User Address : " + address);
        return userService.getUserByUserIDAndAddress(userID, address);
    }
}
