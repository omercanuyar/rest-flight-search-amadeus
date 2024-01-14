package com.amadeus.restflightsearchamadeus.repository;

import com.amadeus.restflightsearchamadeus.model.Role;
import com.amadeus.restflightsearchamadeus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}
