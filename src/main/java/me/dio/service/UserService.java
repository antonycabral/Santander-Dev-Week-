package me.dio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.model.User;
import me.dio.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    private User create(User user){
        if (user.getId() != null && repository.existsById(user.getId())) {
            throw new IllegalArgumentException("o user id ja existe");
        }
        return repository.save(user);
    }
    
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
