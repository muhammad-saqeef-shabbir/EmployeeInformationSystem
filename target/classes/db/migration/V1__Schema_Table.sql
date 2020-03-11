CREATE TABLE IF NOT EXISTS EMPLOYEE(

id UUID NOT NULL,
name varchar(100) NOT NULL,
role varchar(100) NULL,
cnic varchar(100) NULL,
age INT NULL,
dob VARCHAR(100) NULL,
PRIMARY KEY (id)
);