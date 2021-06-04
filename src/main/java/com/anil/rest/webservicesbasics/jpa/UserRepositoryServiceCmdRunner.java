package com.anil.rest.webservicesbasics.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryServiceCmdRunner implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(UserRepositoryServiceCmdRunner.class);

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Override
    public void run(String... args) throws Exception {
        JpaUser user = new JpaUser("Anil -2 ", "admin");
        userRepositoryService.save(user);
        logger.info("Inserted user is: " + user);
        logger.info("Inserted user id is: " + user.getId());
    }
}
