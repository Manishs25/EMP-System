package com.project.EmpSystem.repository;


import com.project.EmpSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
