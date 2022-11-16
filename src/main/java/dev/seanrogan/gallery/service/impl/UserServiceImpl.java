package dev.seanrogan.gallery.service.impl;

import dev.seanrogan.gallery.model.Role;
import dev.seanrogan.gallery.model.User;
import dev.seanrogan.gallery.repository.RoleRepository;
import dev.seanrogan.gallery.repository.UserRepository;
import dev.seanrogan.gallery.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends UserService implements UserDetailsService {

    private final RoleRepository roleRepo;
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
        log.info("saving user: {} to database" ,  user.getUserName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);

    }
    @Override
    public Role saveRole(Role role) {
        log.info("saving new role: {}" , role.toString());
        return roleRepo.save(role);
    }
    @Override
    public void assignRole(String userName, String roleName) {
        User user = userRepo.findByUserName(userName);
        Role role = roleRepo.findByName(roleName);
        String logMsg = "user: " + user.getUserName() + "assigned role \"" + roleName + "\"";
        log.info(logMsg);
        user.getRoles().add(role);
    }
    @Override
    public User getUser(String userName) {
        return userRepo.findByUserName(userName);
    }
    @Override
    public Page<User> getAllUsers() {
        return userRepo.findAll(Pageable.ofSize(10));
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(userName);
        if(user != null) {
            log.error("user {} not found in database", userName);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        try{
            assert user != null;
            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        } catch (NullPointerException e) {
            log.error(Arrays.toString(e.getStackTrace()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }
}
