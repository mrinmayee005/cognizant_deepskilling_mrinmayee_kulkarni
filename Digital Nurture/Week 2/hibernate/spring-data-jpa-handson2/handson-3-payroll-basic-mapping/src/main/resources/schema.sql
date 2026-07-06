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
  PRIMARY KEY (em_id)
);

CREATE TABLE IF NOT EXISTS skill (
  sk_id INT NOT NULL AUTO_INCREMENT,
  sk_name VARCHAR(50),
  PRIMARY KEY (sk_id)
);

