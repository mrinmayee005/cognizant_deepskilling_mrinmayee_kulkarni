package com.example.ems.service;

import com.example.ems.entity.Employee;
import com.example.ems.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeBatchService {

    private final EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Employee> bulkCreate(List<Employee> employees) {
        List<Employee> saved = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            saved.add(employeeRepository.save(employees.get(i)));
            if (i > 0 && i % 20 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        return saved;
    }

    @Transactional(readOnly = true)
    public Map<String, Object> getHibernateStatistics() {
        Session session = entityManager.unwrap(Session.class);
        Statistics stats = session.getSessionFactory().getStatistics();
        return Map.of(
                "entityLoadCount", stats.getEntityLoadCount(),
                "entityInsertCount", stats.getEntityInsertCount(),
                "entityUpdateCount", stats.getEntityUpdateCount(),
                "queryExecutionCount", stats.getQueryExecutionCount()
        );
    }
}
