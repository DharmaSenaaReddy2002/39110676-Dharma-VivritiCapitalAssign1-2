package com.example.VcapitalProject.services;

import com.example.VcapitalProject.domain.UserDto;
import com.example.VcapitalProject.exceptions.CustomException;
import com.example.VcapitalProject.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserDto user = userRepository.save(userDto);
        return user;
    }

    @Override
    public UserDto getUserDetails(Long userId) {
        Optional<UserDto> userDetails = userRepository.findById(userId);
        if(!userDetails.isPresent()){
            throw new CustomException("No Record Found");
        }
        return userDetails.get();
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        try {
            UserDto userObj = userRepository.findById(userDto.getId()).get();

            if (null == userObj) {
                throw new CustomException("No Record Found");
            }
            return userRepository.save(userDto);
        } catch (Exception e) {
            throw new CustomException("Error while Updating Record");
        }
    }
    @Override
    public void deleteUser(Long userId) {
        try {
            UserDto userObj=userRepository.findById(userId).get();

            if(null==userObj) {
                throw new CustomException("No Record Found");
            }
            userRepository.delete(userObj);
        }
        catch(Exception e) {
            throw new CustomException("Unable to delete Record");
        }
    }

}