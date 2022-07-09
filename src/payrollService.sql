#uc 1
create database payroll_service;
use payroll_service;
select database();
create table employee_payroll(
id int unsigned not null auto_increment,
name varchar(150),
salary double not null,
primary key (id)
);
drop table employee_payroll;
#uc 2
create table employee_payroll(
id int unsigned not null auto_increment,
name varchar(150),
salary double not null,
start date not null,
primary key (id)
);
show databases;
desc employee_payroll;
#uc 3
insert into employee_payroll (name,salary,start) values
('Bill',1000000.00,'2018-01-03'),
('Terisa',2000000.00,'2019-11-13'),
('Charlie',3000000.00,'2020-05-21');
desc employee_payroll;
#UC4
select * from employee_payroll;
#UC5
select * from employee_payroll where name='bill';
select salary from employee_payroll where name ='Terisa';
select * from employee_payroll where start between cast('2019-01-01' as date) and date(now());
#UC6
alter table employee_payroll add gender char(1) after name;
desc employee_payroll;
update employee_payroll set gender = 'M' where id =1;
update employee_payroll set gender = 'f' where name ='Charlie';
delete from employee_payroll where id=5 and 6;
desc employee_payroll;
select * from employee_payroll;
delete from employee_payroll where id=6;
update employee_payroll set gender = 'F' where id =2;
select *from employee_payroll limit 2;
update employee_payroll set gender = 'F' where id =3;
select gender,avg(salary) from employee_payroll group by gender;
select gender,max(salary) from employee_payroll ;