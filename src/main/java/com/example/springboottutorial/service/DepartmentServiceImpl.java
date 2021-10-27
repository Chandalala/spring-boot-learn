package com.example.springboottutorial.service;

import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.error.DepartmentNotFoundException;
import com.example.springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDeptsById(Long deptId) throws DepartmentNotFoundException {
        if (!departmentRepository.findById(deptId).isPresent()){
            throw new DepartmentNotFoundException("Dept not found");
        }
        return departmentRepository.getById(deptId);
    }

    @Override
    public String removeDeptById(Long deptId) {
        departmentRepository.deleteById(deptId);
        return "Dept removed";
    }

    @Override
    public Department updateDept(Long deptId, Department department) {

        Department department1 = departmentRepository.getById(deptId);

        department1.setDeptAddress(department.getDeptAddress());
        department1.setDeptName(department.getDeptName());




        return departmentRepository.save(department1);
    }

    @Override
    public Department fetchDeptsByName(String name) {
        return departmentRepository.findDepartmentByDeptName(name);
    }
}
