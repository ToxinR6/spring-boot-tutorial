package com.toxin.spring_boot_tutorial.controller;

import com.toxin.spring_boot_tutorial.entity.Department;
import com.toxin.spring_boot_tutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartment(){
        return departmentService.fetchDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id")Long departmentId){
        return departmentService.fetchDepartmentByID(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentByID(@PathVariable("id")Long departmentId){
        departmentService.deleteDepartmentByID(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department ){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name")String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
