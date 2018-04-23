package com.mate.bedok.squadCook.services;

import com.mate.bedok.squadCook.Utils.Validator;
import com.mate.bedok.squadCook.entities.User;
import com.mate.bedok.squadCook.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository ur;

    public void saveUser(User user) {
        ur.save(user);
    }

    public User getUserById(int id) {
        return ur.findOne((long) id);
    }

    public User getUserByEmail(String email) {
        return ur.getUserByEmail(email);
    }

    public User getCurrentUser(HttpServletRequest request) {
        return getUserByEmail(request.getUserPrincipal().getName());
    }

}
