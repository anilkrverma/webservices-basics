package com.anil.rest.webservicesbasics.user;

import com.anil.rest.webservicesbasics.jpa.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;

//This allows entities to be managed automatically
public interface UserRepositoryService extends JpaRepository<User, Integer> {
}
