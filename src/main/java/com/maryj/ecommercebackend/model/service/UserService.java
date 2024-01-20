package com.maryj.ecommercebackend.model.service;

import com.maryj.ecommercebackend.model.dto.RegistrationBody;
import com.maryj.ecommercebackend.model.exception.UserAlreadyExistException;
import com.maryj.ecommercebackend.model.model.LocalUser;
import com.maryj.ecommercebackend.model.repository.LocalUserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private LocalUserRepo localUserRepo;
private EncryptionService encryptionService;

    public UserService(LocalUserRepo localUserRepo, EncryptionService encryptionService) {
        this.localUserRepo = localUserRepo;
        this.encryptionService = encryptionService;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistException {
 if (localUserRepo.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()|| localUserRepo.findByEmail(registrationBody.getEmail()).isPresent()){
throw new UserAlreadyExistException();
}       LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
       return localUserRepo.save(user);
    }
}
