package com.laura.backenddev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.laura.backenddev.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
