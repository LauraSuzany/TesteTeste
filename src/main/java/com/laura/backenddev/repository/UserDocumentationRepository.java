package com.laura.backenddev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laura.backenddev.entity.UserDocumentation;

@Repository
public interface UserDocumentationRepository extends JpaRepository <UserDocumentation, Long> {


}
