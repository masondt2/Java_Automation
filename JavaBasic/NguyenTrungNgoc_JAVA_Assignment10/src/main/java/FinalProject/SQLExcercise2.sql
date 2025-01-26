USE master;
DROP DATABASE Management;
CREATE DATABASE Management;
USE Management;

CREATE TABLE dbo.Student(
	Id VARCHAR(10) PRIMARY KEY not null,
	LastName VARCHAR(30),
	FirstName VARCHAR(30),
	EnrollmentDate Date
)

CREATE TABLE dbo.Course(
	Id VARCHAR(10) PRIMARY KEY not null,
	Title VARCHAR(30),
	Credits INT
)

CREATE TABLE dbo.Enrollment(
	Id VARCHAR(10) PRIMARY KEY not null,
	CourseId VARCHAR(10) FOREIGN KEY REFERENCES dbo.Course(Id),
	StudentId VARCHAR(10) FOREIGN KEY REFERENCES dbo.Student(Id),
	Grade CHAR(1),
	)

INSERT INTO dbo.Course(Id,Title,Credits)
VALUES
	('1','JAVA1',5),
	('2','Python1',4),
	('3','C++',5)

INSERT INTO dbo.Student(Id,FirstName,LastName,EnrollmentDate)
VALUES
	('1','Nguyen','Trung Ngoc','2023-1-4'),
	('2','Nguyen','Thi Huong','2022-08-09'),
	('3','Le','Doan My','2022-04-07')

INSERT INTO dbo.Enrollment(Id,CourseId,StudentId,Grade)
VALUES
	('2','2','2','A'),
	('3','3','2','B')

GO
CREATE PROCEDURE updateCourseByCal(
	@Id VARCHAR(10),
	@Title VARCHAR(20),
	@Credits Int,
	@status VARCHAR(10) OUTPUT
)

AS BEGIN
	UPDATE dbo.Course
	SET
		Credits = @Credits

	WHERE 
		Title = @Title;
	IF (@@ROWCOUNT>0)
		BEGIN
			SET @status = 'Success';
		END
	ELSE
		BEGIN
			SET @status = 'Fail';
		END
END
