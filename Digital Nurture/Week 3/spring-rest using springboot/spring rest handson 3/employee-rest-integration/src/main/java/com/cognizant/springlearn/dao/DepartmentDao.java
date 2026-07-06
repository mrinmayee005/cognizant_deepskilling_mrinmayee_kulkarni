package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentDao.class);
    
    private static List<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        logger.info("DepartmentDao constructor called");
    }

    public void setDepartmentList(List<Department> departmentList) {
        DEPARTMENT_LIST = departmentList;
    }

    public List<Department> getAllDepartments() {
        logger.info("START - getAllDepartments()");
        logger.info("END - getAllDepartments()");
        return DEPARTMENT_LIST;
    }
}
