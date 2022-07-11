# UC1
        #---------------Creating database-----------
        create database EmployeePayrollService;
        show databases;
        use EmployeePayrollService;

        #UC2
        #----------------CREATING TABLES----------

        create table EmployeePayroll(id int not null auto_increment primary key,
        name varchar(15),
        salary int,
        start_date date not null);
        select *from EmployeePayroll;

        #UC3
        #----------inserting the new data-------------

        insert into EmployeePayroll(name,salary,start_date) values("Asjad",1234,"2019-01-02");
        insert into EmployeePayroll(name,salary,start_date) values("Owais",1000,"2020-03-04");
        insert into EmployeePayroll(name,salary,start_date) values("Adeeb",2000,"2019-04-08");
        select *from EmployeePayroll;



        #UC4
        #------------------Abilty to retrive the data------------

        select *from EmployeePayroll;

        #UC5
        #-------------Abilty to retrive particular data-----------

        select * from EmployeePayroll where name="Asjad";
        select * from EmployeePayroll where start_date="2019-04-08";
        select * from EmployeePayroll where start_date between cast("2020-01-01" as date ) and date(now());

        #UC6
        #-------------------------Ability to add new column And update the value------------

        alter table EmployeePayroll add column gender varchar(1);
        update EmployeePayroll set gender ="M" where id =1;
        update EmployeePayroll set gender ="M" where id =2;
        update EmployeePayroll set gender ="M" where id =3;
        #UC7
        # -------------------Abilty to find the sum,min,max,avg count etc------------------------

        select sum(salary) from EmployeePayroll where gender ="M" group by gender;
        select min(salary) from EmployeePayroll where gender ="M" group by gender;
        select max(salary) from EmployeePayroll where gender ="M" group by gender;
        select avg(salary) from EmployeePayroll where gender ="M" group by gender;
        select count(salary) from EmployeePayroll where gender ="M" group by gender;

        #UC8
        #-------------Using ER diagram----------------
        #---------------Ability to addAbility to extend employee_payroll data to store employee information
        #--like employee phone, address
        #--and department - Ensure employee department

        alter table EmployeePayroll add address varchar(50) default 'Karnatka';
        alter table EmployeePayroll add phonenumber int;
        alter table EmployeePayroll add department varchar(12) not null;

        select * from EmployeePayroll;

        #UC9
        #----------------Ability to extend employee_payroll table to have Basic Pay,
        #----------------Deductions, Taxable Pay, Income Tax, Net Pay--------------,

        alter table EmployeePayroll rename column salary to basic_pay;
        alter table EmployeePayroll add column deductions int;
        alter table EmployeePayroll add column Taxable_Pay int;
        alter table EmployeePayroll add column Income_Tax int;
        alter table EmployeePayroll add column Net_Pay int;

        select * from EmployeePayroll;

        #UC10
        #--------Ability to make Terissa as part of Sales and Marketing Department----
        Insert Into EmployeePayroll Values(4,'Terissa',20000,'2021-10-22','F','America',8748,'Marketing',2000,1000,200,18000);

        select * from EmployeePayroll;

        #UC11

        alter table EmployeePayroll drop column department;

        create table Department(dID int Primary Key , departmentName varchar(30));

        insert into department values(1 , "Marketing");
        insert into department values(2 , "Sales");
        select * from department;

        #UC12

        create table emp_Dept (eID int Not Null , dID int Not Null);

        insert into emp_dept values(3,1);

        insert into emp_dept values(3,2);

        select * from emp_dept;

        select EmployeePayroll.name, EmployeePayroll.dID from EmployeePayroll inner Join emp_dept ON EmployeePayroll.dID = emp_dept.eID;
