package com.nbti.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nbti.backEnd.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
