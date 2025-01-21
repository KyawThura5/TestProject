package com.test.CRUDSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.CRUDSpringBoot.model.Students;

public interface StudentRepo extends JpaRepository<Students,Long> {

}
