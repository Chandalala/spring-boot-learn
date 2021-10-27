package com.example.springboottutorial.controller;

import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.error.DepartmentNotFoundException;
import com.example.springboottutorial.service.DepartmentService;
import com.example.springboottutorial.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    //DepartmentService departmentService = new DepartmentServiceImpl();
    //Instead of the above, check inversion of control below

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/departments")
    public Department saveDept(@Valid @RequestBody Department department){

        LOGGER.info("Inside save dept");

        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments(){

        return departmentService.fetchDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDeptsById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {

        return departmentService.fetchDeptsById(deptId);

    }

    @DeleteMapping("/departments/{id}")
    public String removeDeptById(@PathVariable("id") Long deptId){
        return departmentService.removeDeptById(deptId);
    }

    @PutMapping("/departments/{id}")
    public Department updateDept(@PathVariable("id") Long deptId, @RequestBody Department department){
        return departmentService.updateDept(deptId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDeptsByName(@PathVariable("name") String name){

        return departmentService.fetchDeptsByName(name);

    }



    }
