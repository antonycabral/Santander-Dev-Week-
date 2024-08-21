package me.dio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.model.User;
import me.dio.repository.UserRepository;
import me.dio.service.exception.BusinessException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User create(User userToCreate) {
    

        this.validateChangeableId(userToCreate.getId(), "created");
        if (repository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new BusinessException("This account number already exists.");
        }
        if (repository.existsByAccountNumber(userToCreate.getCard().getNumber())) {
            throw new BusinessException("This card number already exists.");
        }
        return this.repository.save(userToCreate);
    }
    
    private void validateChangeableId(Long id, String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateChangeableId'");
    }

    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
