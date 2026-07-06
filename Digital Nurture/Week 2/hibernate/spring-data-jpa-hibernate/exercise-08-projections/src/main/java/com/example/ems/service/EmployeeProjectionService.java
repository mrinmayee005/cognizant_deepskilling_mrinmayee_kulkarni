package com.example.ems.service;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.projection.EmployeeEmailView;
import com.example.ems.projection.EmployeeSummary;
import com.example.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeProjectionService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeSummary> getAllSummaries() {
        return employeeRepository.findAllSummaries();
    }

    public List<EmployeeDto> getAllDtos() {
        return employeeRepository.findAllDtos();
    }

    public List<EmployeeEmailView> searchEmailViews(String namePart) {
        return employeeRepository.findByNameContainingIgnoreCase(namePart, EmployeeEmailView.class);
    }
}
