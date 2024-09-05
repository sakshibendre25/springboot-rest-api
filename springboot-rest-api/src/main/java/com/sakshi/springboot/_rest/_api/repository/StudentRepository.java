package com.sakshi.springboot._rest._api.repository;

import com.sakshi.springboot._rest._api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
