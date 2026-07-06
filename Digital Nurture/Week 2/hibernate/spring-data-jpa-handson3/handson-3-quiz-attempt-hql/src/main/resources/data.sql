SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM attempt_option;
DELETE FROM attempt_question;
DELETE FROM options;
DELETE FROM question;
DELETE FROM attempt;
DELETE FROM quiz_user;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO quiz_user (us_id, us_name) VALUES (1, 'John');
INSERT INTO attempt (at_id, at_us_id, at_date) VALUES (1, 1, '2026-06-24');

INSERT INTO question (qu_id, qu_text) VALUES (1, 'What is the extension of the hyper text markup language file?');
INSERT INTO question (qu_id, qu_text) VALUES (2, 'What is the maximum level of heading tag can be used in a HTML page?');
INSERT INTO question (qu_id, qu_text) VALUES (3, 'The HTML document itself begins with <html> and ends </html>. State True of False');
INSERT INTO question (qu_id, qu_text) VALUES (4, 'Choose the right option to store text value value in a variable');

INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (1, 1, '.xhtm', 0.0, false);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (2, 1, '.ht', 0.0, false);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (3, 1, '.html', 1.0, true);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (4, 1, '.htmx', 0.0, false);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (5, 2, '5', 0.0, false);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (6, 2, '3', 0.0, false);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (7, 2, '4', 0.0, false);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (8, 2, '6', 1.0, true);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (9, 3, 'false', 0.0, false);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (10, 3, 'true', 1.0, true);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (11, 4, '''John''', 0.5, true);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (12, 4, 'John', 0.0, false);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (13, 4, '"John"', 0.5, true);
INSERT INTO options (op_id, op_qu_id, op_text, op_score, op_correct) VALUES (14, 4, '/John/', 0.0, false);

INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (1, 1, 1);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (2, 1, 2);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (3, 1, 3);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (4, 1, 4);

INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 1, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 2, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 3, true);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 4, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 5, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 6, true);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 7, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 8, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (3, 9, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (3, 10, true);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (4, 11, true);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (4, 12, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (4, 13, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (4, 14, false);

