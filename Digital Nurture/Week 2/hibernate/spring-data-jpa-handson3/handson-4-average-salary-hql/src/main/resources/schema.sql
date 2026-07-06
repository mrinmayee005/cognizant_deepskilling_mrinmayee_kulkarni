CREATE TABLE IF NOT EXISTS department (
  dp_id INT NOT NULL AUTO_INCREMENT,
  dp_name VARCHAR(50),
  PRIMARY KEY (dp_id)
);

CREATE TABLE IF NOT EXISTS employee (
  em_id INT NOT NULL AUTO_INCREMENT,
  em_name VARCHAR(100),
  em_salary DOUBLE,
  em_permanent BOOLEAN,
  em_date_of_birth DATE,
  em_dp_id INT,
  PRIMARY KEY (em_id),
  CONSTRAINT fk_employee_department FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

CREATE TABLE IF NOT EXISTS skill (
  sk_id INT NOT NULL AUTO_INCREMENT,
  sk_name VARCHAR(50),
  PRIMARY KEY (sk_id)
);

CREATE TABLE IF NOT EXISTS employee_skill (
  es_em_id INT NOT NULL,
  es_sk_id INT NOT NULL,
  PRIMARY KEY (es_em_id, es_sk_id),
  CONSTRAINT fk_employee_skill_employee FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
  CONSTRAINT fk_employee_skill_skill FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);
