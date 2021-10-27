package com.example.springboottutorial.service;

import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    public void setUp() {
        Department department = Department.builder()
                .deptName("IT")
                .deptAddress("SO SO")
                .deptCode("IT 01")
                .deptId(1L)
                .build();

        Mockito.when(departmentRepository.findDepartmentByDeptName("IT"))
                .thenReturn(department);
    }


    @Test
    public void fetchDeptsByName() {
        String deptName ="IT";
        Department found = departmentService.fetchDeptsByName(deptName);
        assertEquals(deptName, found.getDeptName());

    }
/*    @Test
    void saveDepartment() {
    }

    @Test
    void fetchDepartments() {
    }

    @Test
    void fetchDeptsById() {
    }

    @Test
    void removeDeptById() {
    }

    @Test
    void updateDept() {
    }

*/
}