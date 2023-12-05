package com.immersivex.userRestApi.repo;

import com.immersivex.userRestApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM User WHERE ID=?1",nativeQuery = true)
    User getUserByUserID(String userId);

    @Query(value = "SELECT * FROM User WHERE name=?1 AND address=?2",nativeQuery = true)
    User getUserByUserNameAndAddress(String name,String address);
}
