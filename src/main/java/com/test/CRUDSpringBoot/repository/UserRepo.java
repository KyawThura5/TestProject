package com.test.CRUDSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.CRUDSpringBoot.model.User;

public interface UserRepo extends JpaRepository<User,Long> {

}
