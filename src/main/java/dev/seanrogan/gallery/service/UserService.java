package dev.seanrogan.gallery.service;

import dev.seanrogan.gallery.model.Role;
import dev.seanrogan.gallery.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public abstract class UserService {
    public abstract User saveUser(User user);
    public abstract Role saveRole(Role role);
    public abstract void assignRole(String userName, String roleName);
    public abstract User getUser(String userName);
    public abstract Page<User> getAllUsers();
}
