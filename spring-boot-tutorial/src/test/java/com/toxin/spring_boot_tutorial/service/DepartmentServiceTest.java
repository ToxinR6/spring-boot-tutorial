package com.toxin.spring_boot_tutorial.service;

import com.toxin.spring_boot_tutorial.entity.Department;
import com.toxin.spring_boot_tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockitoBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().
                departmentName("IT").
                departmentAddress("Mumbai").
                departmentCode("IT-06").
                departmentId(1L).
                build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName="IT";
        Department found =departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());

    }
}