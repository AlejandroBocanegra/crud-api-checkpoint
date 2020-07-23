package com.galvanize.crudapicheckpoint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    
    @Query(value= "SELECT * FROM users WHERE id = :id", nativeQuery=true)
    User findPorUserId(Long id);

    @Query(value= "DELETE * FROM users WHERE id = :id", nativeQuery=true)
    User deletePorId(Long id);

    @Query(value= "REPLACE INTO users SET id = :id, email = :email", nativeQuery=true)
    User updatePorEmail(String email);

}