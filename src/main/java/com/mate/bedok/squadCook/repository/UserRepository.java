package com.mate.bedok.squadCook.repository;

import com.mate.bedok.squadCook.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User getUserByUserName(String userName);
    User getUserByEmail(String email);

}
