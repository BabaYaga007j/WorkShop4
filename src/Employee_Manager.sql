create database Employee_Manager;
show databases;
use Employee_Manager;

create table Employee (EmpId int (10) auto_increment primary key,
 firstName varchar (20),
 lastName varchar (20),
 phoneNumber bigint (12),
 salary int (10));
 
 select * from Employee;

 
