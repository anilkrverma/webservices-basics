package com.anil.rest.webservicesbasics.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

//This allows entities to be managed automatically
public interface UserRepositoryService extends JpaRepository<JpaUser, Long> {
}
