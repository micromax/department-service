package com.sadeem.departmentservice.controller;

import com.sadeem.departmentservice.entity.Department;
import com.sadeem.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

        @Autowired
        private DepartmentService departmentService;

        @GetMapping("/index")
        public List<Department> ListAll()
        {
                log.info("Inside ListAll method of DepartmentController");
                return departmentService.findAll();
        }
        @PostMapping("/")
        public Department saveDepartment( @RequestBody Department department)
        {
                log.info("Inside saveDepartment method of DepartmentController");
                return departmentService.saveDepartment(department);
        }

        @PostMapping("/updates")
        public Department updateDepartment( @RequestBody Department department)
        {
                log.info("Inside UpdateDepartment method of DepartmentController");
                return departmentService.UpdateDepartment(department);
        }

        @GetMapping("/{id}")
        public  Department findDepartmentById(@PathVariable("id") Long departmentId)
        {
                log.info("Inside findDepartmentById method of DepartmentController");
                return departmentService.findDepartmentById(departmentId);
        }

}
