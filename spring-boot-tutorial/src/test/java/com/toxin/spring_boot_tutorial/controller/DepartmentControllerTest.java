package com.toxin.spring_boot_tutorial.controller;

import com.toxin.spring_boot_tutorial.entity.Department;
import com.toxin.spring_boot_tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DepartmentService departmentService;


    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().
                departmentName("IT").
                departmentAddress("Mumbai").
                departmentCode("IT-08").
                departmentId(1L).
                build();


    }

    @Test
    void saveDepartment() throws Exception {
       Department inputDepartment = Department.builder().
               departmentName("IT").
               departmentAddress("Mumbai").
               departmentCode("IT-08").
               build();

       Mockito.when(departmentService.saveDepartment(inputDepartment)).
                thenReturn(department);

       mockMvc.perform(post("/departments").
                contentType(MediaType.APPLICATION_JSON).
                content("{\n" +
                        " \"departmentName\": \"IT\",\n" +
                        " \"departmentAddress\": \"Mumbai\",\n" +
                        " \"departmentCode\": \"IT-08\"\n" +
                        "}" )).
                andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentByID() throws Exception {
        Mockito.when(departmentService.fetchDepartmentByID(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                    .value(department.getDepartmentName()));

    }
}