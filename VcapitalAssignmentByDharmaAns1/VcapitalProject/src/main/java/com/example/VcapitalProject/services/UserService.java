package com.example.VcapitalProject.services;

import com.example.VcapitalProject.domain.UserDto;

public interface UserService {

    public UserDto createUser(UserDto userDto);

    public UserDto getUserDetails(Long userId);

    public UserDto updateUser(UserDto userDto);

    public void deleteUser(Long userId);

}
