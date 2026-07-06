package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentDao departmentDao;

    public DepartmentService() {
        logger.info("DepartmentService constructor called");
    }

    @Transactional
    public List<Department> getAllDepartments() {
        logger.info("START - getAllDepartments()");
        List<Department> departments = departmentDao.getAllDepartments();
        logger.info("END - getAllDepartments()");
        return departments;
    }
}
