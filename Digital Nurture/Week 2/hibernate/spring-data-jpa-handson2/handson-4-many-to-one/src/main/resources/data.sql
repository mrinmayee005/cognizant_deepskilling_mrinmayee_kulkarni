SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM employee;
DELETE FROM skill;
DELETE FROM department;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO department (dp_id, dp_name) VALUES (1, 'Technology');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'Human Resources');

INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (1, 'John', 45000, true, '1990-05-10', 1);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (2, 'Mary', 55000, true, '1988-09-21', 1);

INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'Spring Data JPA');

