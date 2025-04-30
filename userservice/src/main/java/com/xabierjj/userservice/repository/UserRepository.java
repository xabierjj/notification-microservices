package com.xabierjj.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xabierjj.userservice.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
}
