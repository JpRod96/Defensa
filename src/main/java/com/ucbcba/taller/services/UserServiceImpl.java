package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.User;
import com.ucbcba.taller.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Jp on 26/04/2017.
 */
@Service
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;

    @Autowired
    @Qualifier(value = "userRepository")
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> listAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveUser(User terminal) {
        return userRepository.save(terminal);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }
}
