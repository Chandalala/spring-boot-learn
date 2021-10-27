package com.example.springboottutorial.service;

import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.error.DepartmentNotFoundException;

import java.util.List;


public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartments();

    Department fetchDeptsById(Long deptId) throws DepartmentNotFoundException;

    String removeDeptById(Long deptId);

    Department updateDept(Long deptId, Department department);

    Department fetchDeptsByName(String name);
}
