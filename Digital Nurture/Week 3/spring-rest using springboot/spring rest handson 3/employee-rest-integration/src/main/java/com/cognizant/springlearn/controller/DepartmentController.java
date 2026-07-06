package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    public DepartmentController() {
        logger.info("DepartmentController constructor called");
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        logger.info("START - getAllDepartments()");
        List<Department> departments = departmentService.getAllDepartments();
        logger.info("END - getAllDepartments()");
        return departments;
    }
}
