package com.anil.rest.webservicesbasics.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryServiceCmdRunner implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(UserRepositoryServiceCmdRunner.class);

    @Autowired
    private UserJpaRepositoryService userJpaRepositoryService;

    @Override
    public void run(String... args) throws Exception {
        JpaUser user = new JpaUser("Anil -2 ", "admin");
        userJpaRepositoryService.save(user);
        logger.info("Inserted user is: " + user);
        logger.info("Inserted user id is: " + user.getId());

        //Use more methods provided by UserRepositoryService

        Optional<JpaUser> userByID = userJpaRepositoryService.findById(1L);
        logger.info("Retrieved user is: " + userByID);

        List<JpaUser> users = userJpaRepositoryService.findAll();
        logger.info("All users in database: " + users);

    }
}
