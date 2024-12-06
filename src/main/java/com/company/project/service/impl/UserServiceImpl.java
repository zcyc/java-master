package com.company.project.service.impl;

import com.company.project.dao.UserMapper;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by CodeGenerator on 2024/11/18.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    public void addUser(User user) {
        user.setRegisterDate(new java.util.Date());
        String encryptedPassword = encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);
        userMapper.insert(user);
    }

    public boolean validateCredentials(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        User user = userMapper.findByUsernameAndPassword(username, encryptedPassword);
        boolean validCredentials = user != null;
        return validCredentials;
    }

    public void save(User user) {
        addUser(user);
    }

    @Override
    public String generateToken() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }
    
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] byteData = md.digest();

            // Convert byte array to hex format
            StringBuilder sb = new StringBuilder();
            for (byte b : byteData) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 encryption failed", e);
        }
    }
}