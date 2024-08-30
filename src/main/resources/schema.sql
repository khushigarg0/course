CREATE TABLE IF NOT EXISTS `course` (
`course_id` INT AUTO_INCREMENT PRIMARY KEY,
`title` VARCHAR(30) NOT NULL,
`duration` VARCHAR(30) NOT NULL,
`author` VARCHAR(30) NOT NULL,
`created_at` DATE DEFAULT NULL,
`created_by` VARCHAR(30) DEFAULT NULL,
`updated_at` DATE DEFAULT NULL,
`updated_by` VARCHAR(30) DEFAULT NULL
);
--
--CREATE TABLE IF NOT EXISTS `enrollment`(
--`e_id`INT,
--`id` INT,
--`course_id`
--`status` VARCHAR(30),
--FOREIGN KEY (course_id) REFERENCES course(course_id)
--);