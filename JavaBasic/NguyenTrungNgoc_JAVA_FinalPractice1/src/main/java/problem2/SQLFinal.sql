USE
MASTER;
DROP
DATABASE FAS;
CREATE
DATABASE FAS;
USE
FAS;

CREATE TABLE dbo.Trainee
(
    trainee_id   INT PRIMARY KEY IDENTITY(1,1) not null,
    account      VARCHAR(30) UNIQUE not null,
    full_name    VARCHAR(100)       not null,
    gender       bit         DEFAULT null,
    birth_date   DATE,
    phone_number VARCHAR(30),
    gpa          NCHAR(10),
    status       VARCHAR(10) DEFAULT 'active' CHECK (status IN ('active', 'in-active'))
)

