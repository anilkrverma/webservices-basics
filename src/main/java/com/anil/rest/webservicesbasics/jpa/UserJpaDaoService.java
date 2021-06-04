package com.anil.rest.webservicesbasics.jpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository //this allows the interaction with database
@Transactional //to enable transactional interaction
public class UserJpaDaoService {

    @PersistenceContext // to enable tracking in persistent context
    private EntityManager entityManager;

    public long insert(JpaUser jpaUser){
        entityManager.persist(jpaUser);

        return jpaUser.getId();
    }
}
