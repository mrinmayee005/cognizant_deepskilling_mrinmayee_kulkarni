DELETE FROM skill;
DELETE FROM employee;
DELETE FROM department;

INSERT INTO department (dp_id, dp_name) VALUES (1, 'Technology');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'Human Resources');

INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth) VALUES (1, 'John', 45000, true, '1990-05-10');
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth) VALUES (2, 'Mary', 55000, true, '1988-09-21');

INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'Spring Data JPA');

