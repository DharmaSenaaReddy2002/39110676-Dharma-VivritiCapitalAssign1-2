package com.example.VcapitalProject.controllers;

import com.example.VcapitalProject.domain.UserDto;
import com.example.VcapitalProject.exceptions.CustomException;
import com.example.VcapitalProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createuser(@Validated @RequestBody UserDto userDto){

        UserDto userDetails=userService.createUser(userDto);
        return new ResponseEntity<>(userDetails, HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getuser(@PathVariable(required=true)Long  userId){
        UserDto userDetails=userService.getUserDetails(userId);

        return new ResponseEntity<>(userDetails,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Validated @RequestBody UserDto userDto){
        if(null==userDto.getId() || userDto.getId()<=0){
            throw new CustomException("Invalid Id");
        }
        UserDto userDetails=userService.updateUser(userDto);
        return new ResponseEntity<>(userDetails,HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable(required=true)Long userId){
        try {
            if (userId <= 0) {
                throw new CustomException("Invalid Id");
            }
            userService.deleteUser(userId);
        }
        catch(Exception e) {
            throw new CustomException("Error While Deleting Record");
        }
        Map<String,Object> map=new HashMap<>();
        map.put("message","Record Deleted Successfully ID :: "+userId);

        return new ResponseEntity<Map>(map,HttpStatus.OK);
    }
}
