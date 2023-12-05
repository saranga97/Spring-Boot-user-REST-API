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
}
