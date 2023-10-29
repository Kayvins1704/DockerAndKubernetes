package com.vinitkayarkar.dockerkubernetes.services;

import com.vinitkayarkar.dockerkubernetes.aspects.Loggable;
import com.vinitkayarkar.dockerkubernetes.aspects.LoggingAspect;
import com.vinitkayarkar.dockerkubernetes.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Loggable
    public User getUserDetails(User user) {
        logger.info("User name is {} and password is {}", user.getUsername(), user.getPassword());
        return user;
    }
}
