package com.anil.rest.webservicesbasics.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

//This allows entities to be managed automatically
public interface UserJpaRepositoryService extends JpaRepository<JpaUser, Long> {
}
