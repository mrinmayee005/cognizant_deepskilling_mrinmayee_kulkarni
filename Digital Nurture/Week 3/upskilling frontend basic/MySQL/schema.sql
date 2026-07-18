-- ============================================================
-- Database Schema for Community Event Portal
-- ============================================================
-- This script creates the complete database schema and inserts
-- sample data for use in all 25 MySQL exercises.
-- ============================================================

DROP DATABASE IF EXISTS community_portal;
CREATE DATABASE community_portal;
USE community_portal;

-- =====================
-- Table: Users
-- =====================
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL
);

-- =====================
-- Table: Events
-- =====================
CREATE TABLE Events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status ENUM('upcoming', 'completed', 'cancelled') NOT NULL,
    organizer_id INT,
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);

-- =====================
-- Table: Sessions
-- =====================
CREATE TABLE Sessions (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- =====================
-- Table: Registrations
-- =====================
CREATE TABLE Registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- =====================
-- Table: Feedback
-- =====================
CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- =====================
-- Table: Resources
-- =====================
CREATE TABLE Resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    resource_type ENUM('pdf', 'image', 'link') NOT NULL,
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- ============================================================
-- Sample Data
-- ============================================================

-- ---------------------
-- Users
-- ---------------------
INSERT INTO Users (full_name, email, city, registration_date) VALUES
('Alice Johnson', 'alice@example.com', 'New York', '2025-01-15'),
('Bob Smith', 'bob@example.com', 'Los Angeles', '2025-02-20'),
('Charlie Brown', 'charlie@example.com', 'Chicago', '2025-03-10'),
('Diana Prince', 'diana@example.com', 'New York', '2025-04-05'),
('Eve Davis', 'eve@example.com', 'Houston', '2025-05-12'),
('Frank Miller', 'frank@example.com', 'Los Angeles', '2025-06-18'),
('Grace Lee', 'grace@example.com', 'Chicago', '2025-07-22'),
('Hank Wilson', 'hank@example.com', 'Houston', '2025-08-30'),
('Ivy Chen', 'ivy@example.com', 'New York', '2025-09-14'),
('Jack Thomas', 'jack@example.com', 'Los Angeles', '2025-10-01'),
('Karen White', 'karen@example.com', 'Chicago', '2025-11-05'),
('Leo Martinez', 'leo@example.com', 'Houston', '2025-12-10'),
('Mia Garcia', 'mia@example.com', 'New York', '2026-01-20'),
('Nathan Scott', 'nathan@example.com', 'Los Angeles', '2026-02-14'),
('Olivia Adams', 'olivia@example.com', 'Chicago', '2026-03-08'),
('Peter Parker', 'peter@example.com', 'New York', '2026-04-01'),
('Quinn Foster', 'quinn@example.com', 'Houston', '2026-04-15'),
('Rachel Green', 'rachel@example.com', 'Los Angeles', '2026-05-02'),
('Sam Wilson', 'sam@example.com', 'Chicago', '2026-05-20'),
('Tina Hall', 'tina@example.com', 'New York', '2026-06-10'),
('Uma Patel', 'uma@example.com', 'Houston', '2026-06-25'),
('Victor Cruz', 'victor@example.com', 'Los Angeles', '2026-07-01'),
('Wendy Liu', 'wendy@example.com', 'New York', '2026-07-10'),
('Xavier Bell', 'xavier@example.com', 'Chicago', '2026-07-12'),
('Yara Kim', 'yara@example.com', 'Houston', '2026-07-15');

-- ---------------------
-- Events
-- ---------------------
INSERT INTO Events (title, description, city, start_date, end_date, status, organizer_id) VALUES
('Tech Conference 2026', 'Annual technology conference', 'New York', '2026-08-01 09:00:00', '2026-08-03 17:00:00', 'upcoming', 1),
('Data Science Workshop', 'Hands-on data science training', 'Los Angeles', '2026-08-10 10:00:00', '2026-08-11 16:00:00', 'upcoming', 2),
('AI Summit', 'Artificial intelligence summit', 'Chicago', '2026-07-20 09:00:00', '2026-07-22 17:00:00', 'completed', 3),
('Cloud Computing Expo', 'Cloud technologies exhibition', 'Houston', '2026-09-01 09:00:00', '2026-09-02 17:00:00', 'upcoming', 5),
('DevOps Meetup', 'DevOps best practices meetup', 'New York', '2026-06-15 14:00:00', '2026-06-15 18:00:00', 'completed', 4),
('Cybersecurity Forum', 'Cybersecurity trends forum', 'Los Angeles', '2026-06-20 09:00:00', '2026-06-21 17:00:00', 'completed', 6),
('Mobile Dev Conference', 'Mobile development conference', 'Chicago', '2026-10-05 09:00:00', '2026-10-07 17:00:00', 'upcoming', 7),
('UX Design Workshop', 'User experience design workshop', 'Houston', '2026-05-10 10:00:00', '2026-05-11 16:00:00', 'completed', 8),
('Startup Pitch Night', 'Startup pitches and networking', 'New York', '2026-07-25 18:00:00', '2026-07-25 22:00:00', 'cancelled', 9),
('Blockchain Summit', 'Blockchain technology summit', 'Los Angeles', '2026-11-01 09:00:00', '2026-11-02 17:00:00', 'upcoming', 10),
('Python Bootcamp', 'Intensive Python training', 'Chicago', '2026-05-01 09:00:00', '2026-05-03 17:00:00', 'completed', 11),
('Web Dev Summit', 'Web development summit', 'Houston', '2026-04-10 09:00:00', '2026-04-12 17:00:00', 'completed', 12),
('IoT Conference', 'Internet of Things conference', 'New York', '2026-12-01 09:00:00', '2026-12-02 17:00:00', 'upcoming', 13),
('ML Workshop', 'Machine learning hands-on', 'Los Angeles', '2026-03-15 10:00:00', '2026-03-16 16:00:00', 'completed', 14),
('VR/AR Expo', 'Virtual and augmented reality expo', 'Chicago', '2026-08-20 09:00:00', '2026-08-21 17:00:00', 'upcoming', 15);

-- ---------------------
-- Sessions
-- ---------------------
INSERT INTO Sessions (event_id, title, speaker_name, start_time, end_time) VALUES
(1, 'Opening Keynote', 'Dr. Alan Turing', '2026-08-01 09:00:00', '2026-08-01 10:30:00'),
(1, 'AI in Enterprise', 'Dr. Alan Turing', '2026-08-01 11:00:00', '2026-08-01 12:00:00'),
(1, 'Cloud Native Apps', 'Sarah Connor', '2026-08-01 13:00:00', '2026-08-01 14:30:00'),
(1, 'Cybersecurity Panel', 'James Bond', '2026-08-02 09:00:00', '2026-08-02 10:30:00'),
(1, 'Closing Remarks', 'Dr. Alan Turing', '2026-08-03 15:00:00', '2026-08-03 16:00:00'),
(2, 'Intro to Data Science', 'Prof. Ada Lovelace', '2026-08-10 10:00:00', '2026-08-10 12:00:00'),
(2, 'Python for Data Analysis', 'Prof. Ada Lovelace', '2026-08-10 13:00:00', '2026-08-10 15:00:00'),
(2, 'Machine Learning Basics', 'Dr. Grace Hopper', '2026-08-11 10:00:00', '2026-08-11 12:00:00'),
(3, 'Deep Learning Revolution', 'Dr. Geoffrey Hinton', '2026-07-20 09:00:00', '2026-07-20 11:00:00'),
(3, 'NLP Advances', 'Dr. Geoffrey Hinton', '2026-07-20 13:00:00', '2026-07-20 15:00:00'),
(3, 'Computer Vision Workshop', 'Dr. Fei-Fei Li', '2026-07-21 09:00:00', '2026-07-21 12:00:00'),
(3, 'AI Ethics Panel', 'Dr. Fei-Fei Li', '2026-07-22 09:00:00', '2026-07-22 11:00:00'),
(4, 'AWS Deep Dive', 'James Bond', '2026-09-01 09:00:00', '2026-09-01 11:00:00'),
(4, 'Azure Fundamentals', 'Sarah Connor', '2026-09-01 13:00:00', '2026-09-01 15:00:00'),
(4, 'GCP Workshop', 'Sarah Connor', '2026-09-02 09:00:00', '2026-09-02 12:00:00'),
(5, 'Docker & Kubernetes', 'Dr. Grace Hopper', '2026-06-15 14:00:00', '2026-06-15 16:00:00'),
(5, 'CI/CD Pipelines', 'Dr. Grace Hopper', '2026-06-15 16:00:00', '2026-06-15 18:00:00'),
(6, 'Ethical Hacking', 'James Bond', '2026-06-20 09:00:00', '2026-06-20 11:00:00'),
(6, 'Network Security', 'James Bond', '2026-06-20 13:00:00', '2026-06-20 15:00:00'),
(6, 'Incident Response', 'Dr. Alan Turing', '2026-06-21 09:00:00', '2026-06-21 11:00:00'),
(7, 'React Native Workshop', 'Prof. Ada Lovelace', '2026-10-05 09:00:00', '2026-10-05 12:00:00'),
(7, 'Flutter Development', 'Dr. Grace Hopper', '2026-10-06 09:00:00', '2026-10-06 12:00:00'),
(7, 'Mobile Testing', 'Dr. Grace Hopper', '2026-10-07 09:00:00', '2026-10-07 11:00:00'),
(8, 'Design Thinking', 'Dr. Fei-Fei Li', '2026-05-10 10:00:00', '2026-05-10 12:00:00'),
(8, 'Prototyping Tools', 'Dr. Fei-Fei Li', '2026-05-11 10:00:00', '2026-05-11 12:00:00'),
(10, 'Blockchain Basics', 'Dr. Geoffrey Hinton', '2026-11-01 09:00:00', '2026-11-01 11:00:00'),
(10, 'Smart Contracts', 'Dr. Geoffrey Hinton', '2026-11-01 13:00:00', '2026-11-01 15:00:00'),
(10, 'DeFi Workshop', 'Dr. Geoffrey Hinton', '2026-11-02 09:00:00', '2026-11-02 12:00:00'),
(11, 'Python Fundamentals', 'Prof. Ada Lovelace', '2026-05-01 09:00:00', '2026-05-01 12:00:00'),
(11, 'Advanced Python', 'Prof. Ada Lovelace', '2026-05-02 09:00:00', '2026-05-02 12:00:00'),
(11, 'Python for Web', 'Sarah Connor', '2026-05-03 09:00:00', '2026-05-03 12:00:00'),
(12, 'Modern JavaScript', 'Sarah Connor', '2026-04-10 09:00:00', '2026-04-10 11:00:00'),
(12, 'Node.js Deep Dive', 'Sarah Connor', '2026-04-11 09:00:00', '2026-04-11 11:00:00'),
(12, 'React Advanced', 'Dr. Grace Hopper', '2026-04-12 09:00:00', '2026-04-12 11:00:00'),
(13, 'IoT Architecture', 'Dr. Alan Turing', '2026-12-01 09:00:00', '2026-12-01 11:00:00'),
(13, 'Edge Computing', 'Dr. Alan Turing', '2026-12-02 09:00:00', '2026-12-02 11:00:00'),
(14, 'Neural Networks 101', 'Dr. Geoffrey Hinton', '2026-03-15 10:00:00', '2026-03-15 12:00:00'),
(14, 'TensorFlow Hands-On', 'Dr. Fei-Fei Li', '2026-03-16 10:00:00', '2026-03-16 12:00:00'),
(15, 'VR Development Intro', 'Dr. Fei-Fei Li', '2026-08-20 09:00:00', '2026-08-20 11:00:00'),
(15, 'ARKit Workshop', 'Dr. Fei-Fei Li', '2026-08-21 09:00:00', '2026-08-21 11:00:00');

-- ---------------------
-- Registrations
-- ---------------------
INSERT INTO Registrations (user_id, event_id, registration_date) VALUES
(1, 1, '2026-06-15'), (1, 3, '2026-05-01'), (1, 5, '2026-04-10'),
(2, 2, '2026-07-01'), (2, 6, '2026-05-15'), (2, 14, '2026-02-10'),
(3, 3, '2026-04-20'), (3, 7, '2026-08-01'), (3, 11, '2026-03-01'),
(4, 1, '2026-06-20'), (4, 5, '2026-04-12'), (4, 9, '2026-06-01'),
(5, 4, '2026-07-10'), (5, 8, '2026-03-20'), (5, 12, '2026-02-15'),
(6, 2, '2026-07-05'), (6, 6, '2026-05-10'), (6, 10, '2026-09-01'),
(7, 3, '2026-04-25'), (7, 7, '2026-08-05'), (7, 11, '2026-03-05'),
(8, 4, '2026-07-15'), (8, 8, '2026-03-25'), (8, 13, '2026-10-01'),
(9, 1, '2026-06-25'), (9, 9, '2026-06-05'), (9, 15, '2026-07-01'),
(10, 2, '2026-07-10'), (10, 6, '2026-05-20'), (10, 10, '2026-09-05'),
(11, 3, '2026-05-01'), (11, 7, '2026-08-10'), (11, 11, '2026-03-10'),
(12, 4, '2026-07-20'), (12, 8, '2026-04-01'), (12, 12, '2026-02-20'),
(13, 1, '2026-07-01'), (13, 13, '2026-10-05'), (13, 15, '2026-07-10'),
(14, 2, '2026-07-15'), (14, 10, '2026-09-10'), (14, 14, '2026-02-01'),
(15, 3, '2026-05-10'), (15, 7, '2026-08-15'), (15, 11, '2026-03-15'),
(16, 1, '2026-07-05'), (16, 5, '2026-04-20'), (16, 13, '2026-10-10'),
(17, 4, '2026-07-25'), (17, 8, '2026-04-05'), (17, 12, '2026-02-25'),
(18, 2, '2026-07-20'), (18, 6, '2026-06-01'), (18, 10, '2026-09-15'),
(19, 3, '2026-05-15'), (19, 7, '2026-08-20'), (19, 11, '2026-03-20'),
(20, 1, '2026-07-10'), (20, 13, '2026-10-15'), (20, 15, '2026-07-15'),
(21, 4, '2026-08-01'), (21, 8, '2026-04-10'), (21, 12, '2026-03-01'),
(22, 2, '2026-07-25'), (22, 10, '2026-09-20'), (22, 14, '2026-02-10'),
(23, 1, '2026-07-15'), (23, 5, '2026-05-01'), (23, 13, '2026-10-20'),
(24, 3, '2026-05-20'), (24, 7, '2026-08-25'), (24, 11, '2026-03-25'),
(25, 4, '2026-08-05'), (25, 8, '2026-04-15'), (25, 12, '2026-03-05');

-- ---------------------
-- Feedback
-- ---------------------
INSERT INTO Feedback (user_id, event_id, rating, comments, feedback_date) VALUES
(1, 3, 5, 'Excellent event, learned a lot!', '2026-07-23'),
(1, 5, 4, 'Great meetup, well organized.', '2026-06-16'),
(2, 6, 4, 'Very informative sessions.', '2026-06-22'),
(2, 14, 5, 'Best workshop I have attended.', '2026-03-17'),
(3, 3, 5, 'Amazing speakers and content.', '2026-07-23'),
(3, 11, 4, 'Good bootcamp, could use more exercises.', '2026-05-04'),
(4, 5, 3, 'Decent but felt rushed.', '2026-06-16'),
(4, 9, 2, 'Event was cancelled, disappointing.', '2026-06-26'),
(5, 8, 5, 'Fantastic UX workshop!', '2026-05-12'),
(5, 12, 4, 'Solid web dev content.', '2026-04-13'),
(6, 6, 5, 'Loved the cybersecurity sessions.', '2026-06-22'),
(6, 10, 3, 'Good but too basic for my level.', '2026-11-03'),
(7, 3, 4, 'Well organized conference.', '2026-07-23'),
(7, 11, 5, 'Perfect Python training.', '2026-05-04'),
(8, 8, 4, 'Great hands-on exercises.', '2026-05-12'),
(8, 13, 2, 'Too crowded, hard to follow.', '2026-12-03'),
(9, 1, 3, 'Average conference, expected more.', '2026-08-04'),
(10, 2, 5, 'Data science workshop was top notch.', '2026-08-12'),
(10, 14, 4, 'Good ML content.', '2026-03-17'),
(11, 3, 4, 'Solid AI content.', '2026-07-23'),
(11, 7, 5, 'Mobile dev conference was brilliant!', '2026-10-08'),
(12, 12, 3, 'Web summit was okay, nothing new.', '2026-04-13'),
(13, 1, 4, 'Good variety of topics.', '2026-08-04'),
(14, 2, 5, 'Excellent data science content.', '2026-08-12'),
(14, 10, 4, 'Blockchain summit was informative.', '2026-11-03'),
(15, 3, 3, 'Good but room for improvement.', '2026-07-23'),
(15, 11, 2, 'Too fast paced for beginners.', '2026-05-04'),
(16, 1, 5, 'Outstanding tech conference!', '2026-08-04'),
(16, 13, 4, 'IoT sessions were engaging.', '2026-12-03'),
(17, 12, 3, 'Web dev content was decent.', '2026-04-13'),
(18, 10, 5, 'Blockchain summit exceeded expectations.', '2026-11-03'),
(19, 3, 4, 'AI summit was well curated.', '2026-07-23'),
(20, 1, 4, 'Great networking opportunities.', '2026-08-04'),
(20, 15, 5, 'VR expo was mind-blowing!', '2026-08-22'),
(21, 8, 4, 'UX workshop was practical and useful.', '2026-05-12'),
(22, 14, 3, 'ML workshop needs more depth.', '2026-03-17'),
(23, 5, 5, 'DevOps meetup was excellent!', '2026-06-16'),
(24, 3, 4, 'Good AI sessions overall.', '2026-07-23'),
(25, 8, 3, 'UX was okay but too short.', '2026-05-12');

-- ---------------------
-- Resources
-- ---------------------
INSERT INTO Resources (event_id, resource_type, resource_url, uploaded_at) VALUES
(1, 'pdf', 'https://portal.example.com/resources/tech_conf_agenda.pdf', '2026-07-01 10:00:00'),
(1, 'image', 'https://portal.example.com/resources/tech_conf_banner.png', '2026-07-01 10:05:00'),
(1, 'link', 'https://portal.example.com/resources/tech_conf_venue_map', '2026-07-01 10:10:00'),
(2, 'pdf', 'https://portal.example.com/resources/data_science_notes.pdf', '2026-07-15 14:00:00'),
(2, 'image', 'https://portal.example.com/resources/data_science_infographic.png', '2026-07-15 14:05:00'),
(3, 'pdf', 'https://portal.example.com/resources/ai_summit_proceedings.pdf', '2026-06-25 09:00:00'),
(3, 'image', 'https://portal.example.com/resources/ai_summit_photos.png', '2026-06-25 09:05:00'),
(3, 'link', 'https://portal.example.com/resources/ai_summit_slides', '2026-06-25 09:10:00'),
(3, 'pdf', 'https://portal.example.com/resources/ai_ethics_paper.pdf', '2026-06-25 09:15:00'),
(4, 'link', 'https://portal.example.com/resources/cloud_expo_registration', '2026-08-01 11:00:00'),
(5, 'pdf', 'https://portal.example.com/resources/devops_cheatsheet.pdf', '2026-06-01 10:00:00'),
(5, 'link', 'https://portal.example.com/resources/devops_tools_list', '2026-06-01 10:05:00'),
(6, 'pdf', 'https://portal.example.com/resources/cybersecurity_guide.pdf', '2026-06-10 12:00:00'),
(6, 'image', 'https://portal.example.com/resources/security_architecture.png', '2026-06-10 12:05:00'),
(7, 'pdf', 'https://portal.example.com/resources/mobile_dev_handbook.pdf', '2026-09-01 09:00:00'),
(8, 'pdf', 'https://portal.example.com/resources/ux_workbook.pdf', '2026-04-25 14:00:00'),
(8, 'image', 'https://portal.example.com/resources/ux_tools_comparison.png', '2026-04-25 14:05:00'),
(8, 'link', 'https://portal.example.com/resources/ux_resources_page', '2026-04-25 14:10:00'),
(11, 'pdf', 'https://portal.example.com/resources/python_exercises.pdf', '2026-04-20 10:00:00'),
(11, 'link', 'https://portal.example.com/resources/python_docs', '2026-04-20 10:05:00'),
(12, 'pdf', 'https://portal.example.com/resources/webdev_tutorial.pdf', '2026-03-25 09:00:00'),
(14, 'pdf', 'https://portal.example.com/resources/ml_tutorial.pdf', '2026-02-20 11:00:00'),
(14, 'image', 'https://portal.example.com/resources/ml_workflow_diagram.png', '2026-02-20 11:05:00'),
(14, 'link', 'https://portal.example.com/resources/ml_resources', '2026-02-20 11:10:00');
