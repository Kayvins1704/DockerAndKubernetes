package com.vinitkayarkar.dockerkubernetes;

import com.vinitkayarkar.dockerkubernetes.aspects.LoggingAspect;
import com.vinitkayarkar.dockerkubernetes.entities.User;
import com.vinitkayarkar.dockerkubernetes.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DockerKubernetesApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    private final ApplicationContext appContext;

    public DockerKubernetesApplication(ApplicationContext applicationContext) {
        this.appContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(DockerKubernetesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserService userService = appContext.getBean(UserService.class);
        User user = new User();
        user.setUsername("Vinit");
        user.setPassword("Vinit");
        userService.getUserDetails(user);
        logger.info("Username is {} and password is {}", user.getUsername(), user.getPassword());
    }
}
