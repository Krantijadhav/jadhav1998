package com.grid.dynamic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grid.dynamic.Entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

	

}
