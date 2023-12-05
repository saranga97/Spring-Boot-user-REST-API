package com.immersivex.userRestApi.repo;

import com.immersivex.userRestApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
