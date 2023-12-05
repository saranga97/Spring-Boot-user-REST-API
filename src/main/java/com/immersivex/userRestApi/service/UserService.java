package com.immersivex.userRestApi.service;

import com.immersivex.userRestApi.dto.UserDTO;
import com.immersivex.userRestApi.entity.User;
import com.immersivex.userRestApi.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    public UserRepo userRepo;
    @Autowired
    public ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO ){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User>userList= userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO updateUser(UserDTO userDTO ){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }
    public UserDTO getUserByUserId(String userID){
        User user=userRepo.getUserByUserID(userID);
        return modelMapper.map(user,UserDTO.class);
    }
    public UserDTO getUserByNameAndAddress(String name, String address){
        User user=userRepo.getUserByUserNameAndAddress(name,address);
        return modelMapper.map(user,UserDTO.class);
    }

}
