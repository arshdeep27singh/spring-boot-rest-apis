package com.codingshuttle.youtube.learningRestAPIs.repository;

import com.codingshuttle.youtube.learningRestAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
