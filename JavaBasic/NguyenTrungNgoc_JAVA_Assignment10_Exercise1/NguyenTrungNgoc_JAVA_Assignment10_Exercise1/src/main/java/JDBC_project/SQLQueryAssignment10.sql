USE
master
CREATE
DATABASE Course_Management;
USE Course_Management;
CREATE TABLE dbo.Course
(
	id VARCHAR(10) PRIMARY KEY,
	title VARCHAR(50),
	credit Int
);

CREATE TABLE dbo.Student
(
	id VARCHAR(10) PRIMARY KEY,
	LastName VARCHAR(30),
	FirstName VARCHAR(30),
	EnrollmentDate DATE
);

CREATE TABLE dbo.Enrollment
(
	id VARCHAR(10) PRIMARY KEY,
	CourseId VARCHAR (10) FOREIGN KEY REFERENCES Course(id),
	StudentId VARCHAR (10) FOREIGN KEY REFERENCES Student(id),
	Grade CHAR(1)

);

INSERT INTO Course_Management.dbo.Course (id, title, credit)
VALUES ('1', 'Java', '5')

INSERT INTO Course_Management.dbo.Student(id, LastName, FirstName, EnrollmentDate)
VALUES ('1', N'Nguyen', N'Trung Ngoc', '2019-02-18')

INSERT INTO Course_Management.dbo.Enrollment(id,CourseId,StudentId,Grade)
VALUES (1,1,1,'A')

