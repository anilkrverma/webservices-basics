package com.anil.rest.webservicesbasics.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserServiceCmdRunner implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(UserServiceCmdRunner.class);

    @Autowired
    private UserJpaDaoService userJpaDaoService;

    @Override
    public void run(String... args) throws Exception {
        JpaUser user = new JpaUser("Anil", "admin");
        long id = userJpaDaoService.insert(user);
        logger.info("Inserted user is: " + user);
        logger.info("Inserted user id is: " + id);
    }
}
