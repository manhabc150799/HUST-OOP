create database students_management;

use students_management;


CREATE TABLE `course` (
  `id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `semester` int DEFAULT NULL,
  `course1` varchar(200) DEFAULT NULL,
  `course2` varchar(200) DEFAULT NULL,
  `course3` varchar(200) DEFAULT NULL,
  `course4` varchar(200) DEFAULT NULL,
  `course5` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student_id` (`student_id`),
  CONSTRAINT `fk_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);


