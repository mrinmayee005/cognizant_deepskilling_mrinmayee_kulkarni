CREATE TABLE IF NOT EXISTS quiz_user (
  us_id INT NOT NULL AUTO_INCREMENT,
  us_name VARCHAR(100) NOT NULL,
  PRIMARY KEY (us_id)
);

CREATE TABLE IF NOT EXISTS attempt (
  at_id INT NOT NULL AUTO_INCREMENT,
  at_us_id INT NOT NULL,
  at_date DATE NOT NULL,
  PRIMARY KEY (at_id),
  CONSTRAINT fk_attempt_user FOREIGN KEY (at_us_id) REFERENCES quiz_user(us_id)
);

CREATE TABLE IF NOT EXISTS question (
  qu_id INT NOT NULL AUTO_INCREMENT,
  qu_text VARCHAR(500) NOT NULL,
  PRIMARY KEY (qu_id)
);

CREATE TABLE IF NOT EXISTS options (
  op_id INT NOT NULL AUTO_INCREMENT,
  op_qu_id INT NOT NULL,
  op_text VARCHAR(100) NOT NULL,
  op_score DOUBLE NOT NULL,
  op_correct BOOLEAN NOT NULL,
  PRIMARY KEY (op_id),
  CONSTRAINT fk_option_question FOREIGN KEY (op_qu_id) REFERENCES question(qu_id)
);

CREATE TABLE IF NOT EXISTS attempt_question (
  aq_id INT NOT NULL AUTO_INCREMENT,
  aq_at_id INT NOT NULL,
  aq_qu_id INT NOT NULL,
  PRIMARY KEY (aq_id),
  CONSTRAINT fk_attempt_question_attempt FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
  CONSTRAINT fk_attempt_question_question FOREIGN KEY (aq_qu_id) REFERENCES question(qu_id)
);

CREATE TABLE IF NOT EXISTS attempt_option (
  ao_id INT NOT NULL AUTO_INCREMENT,
  ao_aq_id INT NOT NULL,
  ao_op_id INT NOT NULL,
  ao_selected BOOLEAN NOT NULL,
  PRIMARY KEY (ao_id),
  CONSTRAINT fk_attempt_option_attempt_question FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id),
  CONSTRAINT fk_attempt_option_option FOREIGN KEY (ao_op_id) REFERENCES options(op_id)
);

