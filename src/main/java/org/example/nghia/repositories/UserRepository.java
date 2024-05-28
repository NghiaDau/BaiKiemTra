package org.example.nghia.repositories;

import org.example.nghia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User getById(String id);
}
