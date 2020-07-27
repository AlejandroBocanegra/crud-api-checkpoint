package com.galvanize.crudapicheckpoint;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    
    // @Query(value= "SELECT * FROM users WHERE id = :id", nativeQuery=true)
    // User findPorUserId(Long id);

    Optional <User> findByEmail (String userName);

}