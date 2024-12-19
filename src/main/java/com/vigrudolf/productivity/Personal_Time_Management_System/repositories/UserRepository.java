package com.vigrudolf.productivity.Personal_Time_Management_System.repositories;

import com.vigrudolf.productivity.Personal_Time_Management_System.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    int countByName(String name);

    void deleteByEmail(String email);
}
