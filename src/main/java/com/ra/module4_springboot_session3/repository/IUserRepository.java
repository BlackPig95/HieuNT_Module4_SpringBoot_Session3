package com.ra.module4_springboot_session3.repository;

import com.ra.module4_springboot_session3.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>
{
    User findByUsername(String username);
}
