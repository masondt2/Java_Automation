USE
master;
DROP
DATABASE Fsoft_Training;
CREATE
DATABASE Fsoft_Training;
USE
Fsoft_Training;

CREATE TABLE dbo.Course
(
    course_id      VARCHAR(5) PRIMARY KEY,
    subject_id     VARCHAR(4),
    course_code    VARCHAR(10),
    course_title   VARCHAR(50),
    num_of_credits INT
);

CREATE TABLE dbo.Student
(
    ssn        INT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    birth_date DATE,
    street     VARCHAR(30),
    phone      VARCHAR(30),
    zip_code   VARCHAR(5)
);

CREATE TABLE dbo.Enrollment
(
    ssn             INT FOREIGN KEY REFERENCES Student (ssn),
    course_id       VARCHAR(5) FOREIGN KEY REFERENCES Course (course_id),
    date_registered DATE,
    grade           CHAR(1),
    CONSTRAINT pk_PersonID PRIMARY KEY (ssn, course_id)
);

INSERT INTO Fsoft_Training.dbo.Course (course_id, subject_id, course_code, course_title, num_of_credits)
VALUES ('AG02', 'AG', 'Angular03', 'Angular 8', 6)
    INSERT
INTO Fsoft_Training.dbo.Course (course_id, subject_id, course_code, course_title, num_of_credits)
VALUES ('JV01', 'JV', 'Java 04', 'Java SE', 11)
INSERT INTO Fsoft_Training.dbo.Course (course_id, subject_id, course_code, course_title, num_of_credits)
VALUES ('VS02', 'VS', 'VueJS02', 'VueJS', 7)

INSERT INTO Fsoft_Training.dbo.Student (ssn, first_name, last_name, birth_date, street, phone, zip_code)
VALUES (1, N'Nguyen Van', N'A', N'1990-02-09', N'HN', N'012345', N'1000')
INSERT INTO Fsoft_Training.dbo.Student (ssn, first_name, last_name, birth_date, street, phone, zip_code)
VALUES (2, N'Nguyen Van', N'B', N'1991-03-10', N'HN', N'012346', N'2000')
INSERT INTO Fsoft_Training.dbo.Student (ssn, first_name, last_name, birth_date, street, phone, zip_code)
VALUES (3, N'Nguyen Van', N'C', N'1992-04-11', N'HN', N'012347', N'3000')

CREATE PROCEDURE usp_UpdateCourse(
    @course_id VARCHAR(5),
    @subject_id VARCHAR(4),
    @course_code VARCHAR(10),
    @title VARCHAR(50),
    @num_of_credits INT,
    @status VARCHAR(10) OUTPUT
)
    AS
BEGIN
    SET
NOCOUNT ON;
UPDATE dbo.Course
SET subject_id     = @subject_id,
    course_title   = @title,
    num_of_credits = @num_of_credits
WHERE course_code = @course_code;

IF
(@@ROWCOUNT > 0)
BEGIN
            SET
@status = 'success';
END
ELSE
BEGIN
            SET
@status = 'fail';
END
END