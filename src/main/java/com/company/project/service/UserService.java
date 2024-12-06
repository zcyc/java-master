package com.company.project.service;
import com.company.project.model.User;
import com.company.project.core.Service;

/**
 * Created by CodeGenerator on 2024/11/18.
 */
public interface UserService extends Service<User> {
    
    /**
     * Adds a user to the system.
     *
     * @param user The user to be added.
     */
    void addUser(User user);

    /**
     * Validates the credentials of a user.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return true if the credentials are valid, false otherwise.
     */
    boolean validateCredentials(String username, String password);

    /**
     * Generates a secure unique 64-bit token.
     *
     * @return A 64-bit token as a String.
     */
    String generateToken();
}