package com.example.springboottutorial.controller;

import com.example.springboottutorial.entity.Department;
import com.example.springboottutorial.error.DepartmentNotFoundException;
import com.example.springboottutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {


         department = Department.builder()
                .deptName("IT")
                .deptAddress("SO SO")
                .deptCode("IT 01")
                 .deptId(1L)
                .build();
    }

    @Test
    @Disabled
    void saveDept() throws Exception {


        Department department = Department.builder()
                .deptName("IT")
                .deptAddress("SO SO")
                .deptCode("IT 01")
                .build();

        Mockito.when(departmentService.saveDepartment(department))
                .thenReturn(this.department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{JSON DATA}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Disabled
    void fetchDeptsById() throws Exception {
        Mockito.when(departmentService.fetchDeptsById(1L))
                .thenReturn(this.department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{JSON DATA}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.deptName")
                        .value(this.department.getDeptName()));


    }
}