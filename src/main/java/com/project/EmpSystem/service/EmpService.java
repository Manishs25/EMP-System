package com.project.EmpSystem.service;

import com.project.EmpSystem.entity.Employee;
import com.project.EmpSystem.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public void addEmp(Employee employee) {
        empRepository.save(employee);
    }

    public List<Employee> getAllEmp() {
        return empRepository.findAll();
    }

    public Employee getEMpById(int id) {
        Optional<Employee> e = empRepository.findById(id);
        if (e.isPresent()) {
            return e.get();
        }
        return null;
    }

    public void deleteEMp(int id) {
        empRepository.deleteById(id);
    }

}
