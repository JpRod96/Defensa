package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.User;

/**
 * Created by Jp on 26/04/2017.
 */
public interface UserService
{
    Iterable<User> listAllUser();

    User getUserById(Integer id);

    User saveUser(User category);

    void deleteUser(Integer id);
}
