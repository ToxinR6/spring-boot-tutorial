package com.toxin.spring_boot_tutorial.service;

import com.toxin.spring_boot_tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

    public Department fetchDepartmentByID(Long departmentId);

    public void deleteDepartmentByID(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
