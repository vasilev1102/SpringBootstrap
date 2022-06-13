package com.example.springBootstrap.repositories;

import com.example.springBootstrap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u from User u join fetch u.roles where u.login = :login")
    User findByLogin(@Param("login")String login);
}
