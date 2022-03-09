	package com.laura.backenddev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.laura.backenddev.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
