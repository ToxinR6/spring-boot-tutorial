package com.toxin.spring_boot_tutorial.service;

import com.toxin.spring_boot_tutorial.entity.Department;
import com.toxin.spring_boot_tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartment();

    Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentByID(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
