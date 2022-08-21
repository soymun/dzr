package com.example.dzr.Repository;

import com.example.dzr.Entity.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    User findUserByEmail(String email);

    @Transactional
    User findUserById(Long id);
}
