UC-1 Ability to create a payroll
service database


mysql> create database payroll_service;
Query OK, 1 row affected (0.02 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| learn              |
| mysql              |
| payroll_service    |
| performance_schema |
| person             |
| sakila             |
| student            |
| sys                |
| user               |
| world              |
+--------------------+
 
=======
 UC-3-Create-Tabledatabase-Payroll-Database

11 rows in set (0.00 sec)




UC-2 Ability to create a employee payroll table
in the payroll service database to
manage employee payrolls
=================================

mysql> Create Table employee_payroll(
    -> id INT unsigned NOT NULL AUTO_INCREMENT,
    -> name VARCHAR(15) NOT NULL,
    -> salary Double NOT NULL,
    -> start DATE NOT NULL,
    -> PRIMARY KEY(id));
Query OK, 0 rows affected (0.04 sec)

mysql> show tables;
+---------------------------+
| Tables_in_payroll_service |
+---------------------------+
| employee_payroll          |
+---------------------------+
1 row in set (0.02 sec)

mysql> desc employee_payroll;
+--------+--------------+------+-----+---------+----------------+
| Field  | Type         | Null | Key | Default | Extra          |
+--------+--------------+------+-----+---------+----------------+
| id     | int unsigned | NO   | PRI | NULL    | auto_increment |
| name   | varchar(15)  | NO   |     | NULL    |                |
| salary | double       | NO   |     | NULL    |                |
| start  | date         | NO   |     | NULL    |                |
+--------+--------------+------+-----+---------+----------------+
4 rows in set (0.02 sec)




UC-3
Ability to create employee payroll data in the payroll service database as part of
CRUD Operation
==================

mysql> insert into employee_payroll(name,salary,start)values
    -> ('Bharti','30000.0','2022-03-04'),
    -> ('Arati','50000.0','2022-05-12'),
    -> ('Shamal','40000.0','2023-08-09');
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select * from employee_payroll;
+----+--------+--------+------------+
| id | name   | salary | start      |
+----+--------+--------+------------+
|  1 | Bharti |  30000 | 2022-03-04 |
|  2 | Arati  |  50000 | 2022-05-12 |
|  3 | Shamal |  40000 | 2023-08-09 |
+----+--------+--------+------------+
3 rows in set (0.00 sec)





UC-4 Ability to retrieve all the employee payroll data that is
added to payroll service database



mysql> select * from employee_payroll;
+----+--------+--------+------------+
| id | name   | salary | start      |
+----+--------+--------+------------+
|  1 | Bharti |  30000 | 2022-03-04 |
|  2 | Arati  |  50000 | 2022-05-12 |
|  3 | Shamal |  40000 | 2023-08-09 |
+----+--------+--------+------------+
3 rows in set (0.00 sec)

 UC-5-Create-Table-database-Payroll-service
UC-5
Ability to retrieve salary data for a particular employee as well as all employees who have
joined in a particular data range from the payroll service database

mysql> select * from employee_payroll
    -> where name = 'Arati';
+----+-------+--------+------------+
| id | name  | salary | start      |
+----+-------+--------+------------+
|  2 | Arati |  50000 | 2022-05-12 |
+----+-------+--------+------------+
1 row in set (0.02 sec)
mysql> select * from employee_payroll where start between cast('2022-01-01' as DATE) and DATE(NOW());
+----+--------+--------+------------+
| id | name   | salary | start      |
+----+--------+--------+------------+
|  1 | Bharti |  30000 | 2022-03-04 |
|  2 | Arati  |  50000 | 2022-05-12 |
+----+--------+--------+------------+
2 rows in set (0.02 sec)




UC-6
Ability to add Gender to Employee Payroll Table and Update the Rows to
reflect the correct Employee Gender


mysql> insert into Employee_Payroll(name,salary,start)values
    -> ('Harsh','50000','2022-04-05');
Query OK, 1 row affected (0.02 sec)

mysql> select * from employee_payroll;
+----+--------+--------+------------+
| id | name   | salary | start      |
+----+--------+--------+------------+
|  1 | Bharti |  30000 | 2022-03-04 |
|  2 | Arati  |  50000 | 2022-05-12 |
|  3 | Shamal |  40000 | 2023-08-09 |
|  4 | Harsh  |  50000 | 2022-04-05 |
+----+--------+--------+------------+
4 rows in set (0.00 sec)

mysql>  alter table Employee_Payroll add gender VARCHAR(6) after name;
Query OK, 0 rows affected (0.06 sec)
Records: 0  Duplicates: 0  Warnings: 0
mysql>  update Employee_Payroll set gender = 'Female' where name = 'Bharti' or name = 'Arati' or name = 'Shamal';
Query OK, 3 rows affected (0.02 sec)
Rows matched: 3  Changed: 3  Warnings: 0

mysql> update Employee_Payroll set gender = 'Male' where  name = 'Harsh';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql>  select * from employee_payroll;
+----+--------+--------+--------+------------+
| id | name   | gender | salary | start      |
+----+--------+--------+--------+------------+
|  1 | Bharti | Female |  30000 | 2022-03-04 |
|  2 | Arati  | Female |  50000 | 2022-05-12 |
|  3 | Shamal | Female |  40000 | 2023-08-09 |
|  4 | Harsh  | Male   |  50000 | 2022-04-05 |
+----+--------+--------+--------+------------+
4 rows in set (0.00 sec)
 UC-7-CreateTable-Prrform-Max-Min-Coloum

UC-7
Ability to find sum, average, min, maxand number of male and female
employees


mysql> select SUM(salary) from Employee_Payroll
    ->  where gender = 'Female' GROUP BY gender;
+-------------+
| SUM(salary) |
+-------------+
|      120000 |
+-------------+
1 row in set (0.02 sec)

mysql> select SUM(salary) from Employee_Payroll
    -> where gender = 'Male' GROUP BY gender;
+-------------+
| SUM(salary) |
+-------------+
|       50000 |
+-------------+
1 row in set (0.00 sec)

mysql>  select AVG(salary) from Employee_Payroll
    ->   GROUP BY gender;
+-------------+
| AVG(salary) |
+-------------+
|       40000 |
|       50000 |
+-------------+
2 rows in set (0.02 sec)

mysql> select MIN(salary) from Employee_Payroll GROUP BY gender;
+-------------+
| MIN(salary) |
+-------------+
|       30000 |
|       50000 |
+-------------+
2 rows in set (0.00 sec)

mysql> select MAX(salary) from Employee_Payroll GROUP BY gender;
+-------------+
| MAX(salary) |
+-------------+
|       50000 |
|       50000 |
+-------------+
2 rows in set (0.00 sec)

mysql>  select COUNT(id) from Employee_Payroll GROUP BY gender;
+-----------+
| COUNT(id) |
+-----------+
|         3 |
|         1 |
+-----------+
2 rows in set (0.00 sec)




UC-8

mysql> describe employee_payroll;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | int unsigned | NO   | PRI | NULL    | auto_increment |
| name        | varchar(15)  | NO   |     | NULL    |                |
| phoneNumber | int          | YES  |     | NULL    |                |
| gender      | varchar(6)   | YES  |     | NULL    |                |
| salary      | double       | NO   |     | NULL    |                |
| start       | date         | NO   |     | NULL    |                |
| phone       | varchar(30)  | NO   |     | NULL    |                |
| department  | varchar(30)  | NO   |     | NULL    |                |
| address     | varchar(30)  | NO   |     | Umred   |                |
+-------------+--------------+------+-----+---------+----------------+
9 rows in set (0.00 sec)

mysql> select * from Employee_Payroll;
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
| id | name   | phoneNumber | gender | salary | start      | phone | department | address   |
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
|  1 | Bharti |        NULL | Female |  30000 | 2022-03-04 |       |            | Bangalore |
|  2 | Arati  |        NULL | Female |  50000 | 2022-05-12 |       |            | Bangalore |
|  3 | Shamal |        NULL | Female |  40000 | 2023-08-09 |       |            | Bangalore |
|  4 | Harsh  |        NULL | Male   |  50000 | 2022-04-05 |       |            | Bangalore |
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
4 rows in set (0.00 sec)

mysql> alter table employee_payroll
    -> modify phonenumber
    -> Varchar(20);
Query OK, 4 rows affected (0.06 sec)
Records: 4  Duplicates: 0  Warnings: 0

mysql>  update employee_payroll set phonenumber = '8908641811'
    ->  where name = 'Shamal';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update employee_payroll set phonenumber = '7008458748'
    -> where name = 'Arati';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update employee_payroll set phonenumber = '8168458748'
    -> where name = 'Bharti';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql>  update employee_payroll set phonenumber = '8978458748'
    -> where name = 'Harsh';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from Employee_Payroll;
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
| id | name   | phonenumber | gender | salary | start      | phone | department | address   |
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
|  1 | Bharti | 8168458748  | Female |  30000 | 2022-03-04 |       |            | Bangalore |
|  2 | Arati  | 7008458748  | Female |  50000 | 2022-05-12 |       |            | Bangalore |
|  3 | Shamal | 8908641811  | Female |  40000 | 2023-08-09 |       |            | Bangalore |
|  4 | Harsh  | 8978458748  | Male   |  50000 | 2022-04-05 |       |            | Bangalore |
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
4 rows in set (0.00 sec)

mysql> update employee_payroll set address = 'Bangalore'
    ->  where name = 'Bharti' or name = 'Arati' or name = 'Shamal' or name = 'Harsh';
Query OK, 0 rows affected (0.00 sec)
Rows matched: 4  Changed: 0  Warnings: 0

mysql> select * from Employee_Payroll;
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
| id | name   | phonenumber | gender | salary | start      | phone | department | address   |
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
|  1 | Bharti | 8168458748  | Female |  30000 | 2022-03-04 |       |            | Bangalore |
|  2 | Arati  | 7008458748  | Female |  50000 | 2022-05-12 |       |            | Bangalore |
|  3 | Shamal | 8908641811  | Female |  40000 | 2023-08-09 |       |            | Bangalore |
|  4 | Harsh  | 8978458748  | Male   |  50000 | 2022-04-05 |       |            | Bangalore |
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
4 rows in set (0.00 sec)

mysql>  update employee_payroll set department = 'Devloper'
    -> where name = 'Bharti';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql>  update employee_payroll set department = 'Testing'
    -> where name = 'Arati';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql>  update employee_payroll set department = 'Production'
    -> where name = 'Shamal';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql>  update employee_payroll set department = 'Analyst'
    -> where name = 'Harsh';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql>  select * from Employee_Payroll;
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
| id | name   | phonenumber | gender | salary | start      | phone | department | address   |
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
|  1 | Bharti | 8168458748  | Female |  30000 | 2022-03-04 |       | Devloper   | Bangalore |
|  2 | Arati  | 7008458748  | Female |  50000 | 2022-05-12 |       | Testing    | Bangalore |
|  3 | Shamal | 8908641811  | Female |  40000 | 2023-08-09 |       | Production | Bangalore |
|  4 | Harsh  | 8978458748  | Male   |  50000 | 2022-04-05 |       | Analyst    | Bangalore |
+----+--------+-------------+--------+--------+------------+-------+------------+-----------+
4 rows in set (0.00 sec)



uc-9-Ability to extend employee_payroll table to have Basic Pay, Deductions, Taxable Pay, Income Tax, Net Pay


mysql>  alter table employee_payroll add basicpay Double NOT NULL after salary;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table employee_payroll add deduction Double NOT NULL after basicpay;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table employee_payroll add taxablepay Double NOT NULL after deduction;
Query OK, 0 rows affected (0.03 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table employee_payroll add incometax Double NOT NULL after taxablepay;
Query OK, 0 rows affected (0.03 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table employee_payroll add netpay Double NOT NULL after incometax;
Query OK, 0 rows affected (0.03 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> describe employee_payroll;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | int unsigned | NO   | PRI | NULL    | auto_increment |
| name        | varchar(15)  | NO   |     | NULL    |                |
| phonenumber | varchar(20)  | YES  |     | NULL    |                |
| gender      | varchar(6)   | YES  |     | NULL    |                |
| salary      | double       | NO   |     | NULL    |                |
| basicpay    | double       | NO   |     | NULL    |                |
| deduction   | double       | NO   |     | NULL    |                |
| taxablepay  | double       | NO   |     | NULL    |                |
| incometax   | double       | NO   |     | NULL    |                |
| netpay      | double       | NO   |     | NULL    |                |
| start       | date         | NO   |     | NULL    |                |
| phone       | varchar(30)  | NO   |     | NULL    |                |
| department  | varchar(30)  | NO   |     | NULL    |                |
| address     | varchar(30)  | NO   |     | Umred   |                |
+-------------+--------------+------+-----+---------+----------------+
14 rows in set (0.00 sec)

mysql> select * from Employee_Payroll;
+----+--------+-------------+--------+--------+----------+-----------+------------+-----------+--------+------------+-------+------------+-----------+
| id | name   | phonenumber | gender | salary | basicpay | deduction | taxablepay | incometax | netpay | start      | phone | department | address   |
+----+--------+-------------+--------+--------+----------+-----------+------------+-----------+--------+------------+-------+------------+-----------+
|  1 | Bharti | 8168458748  | Female |  30000 |        0 |         0 |          0 |         0 |      0 | 2022-03-04 |       | Devloper   | Bangalore |
|  2 | Arati  | 7008458748  | Female |  50000 |        0 |         0 |          0 |         0 |      0 | 2022-05-12 |       | Testing    | Bangalore |
|  3 | Shamal | 8908641811  | Female |  40000 |        0 |         0 |          0 |         0 |      0 | 2023-08-09 |       | Production | Bangalore |
|  4 | Harsh  | 8978458748  | Male   |  50000 |        0 |         0 |          0 |         0 |      0 | 2022-04-05 |       | Analyst    | Bangalore |
+----+--------+-------------+--------+--------+----------+-----------+------------+-----------+--------+------------+-------+------------+-----------+
4 rows in set (0.01 sec)

mysql>  update employee_payroll set basicpay = '13700', deduction = '2000', taxablepay = '1500', incometax = '1500', netpay = '11300'
    -> where name = 'Bharti';
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update employee_payroll set basicpay = '12000', deduction = '1800', taxablepay = '1300', incometax = '1300', netpay = '13400'
    ->  where name = 'Arati';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> update employee_payroll set basicpay = '15000', deduction = '2200', taxablepay = '2000', incometax = '2000', netpay = '10800'
    ->  where name = 'Shamal';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql>  update employee_payroll set basicpay = '15000', deduction = '2200', taxablepay = '2000', incometax = '1600', netpay = '10000'
    ->  where name = 'Harsh';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from Employee_Payroll;
+----+--------+-------------+--------+--------+----------+-----------+------------+-----------+--------+------------+-------+------------+-----------+
| id | name   | phonenumber | gender | salary | basicpay | deduction | taxablepay | incometax | netpay | start      | phone | department | address   |
+----+--------+-------------+--------+--------+----------+-----------+------------+-----------+--------+------------+-------+------------+-----------+
|  1 | Bharti | 8168458748  | Female |  30000 |    13700 |      2000 |       1500 |      1500 |  11300 | 2022-03-04 |       | Devloper   | Bangalore |
|  2 | Arati  | 7008458748  | Female |  50000 |    12000 |      1800 |       1300 |      1300 |  13400 | 2022-05-12 |       | Testing    | Bangalore |
|  3 | Shamal | 8908641811  | Female |  40000 |    15000 |      2200 |       2000 |      2000 |  10800 | 2023-08-09 |       | Production | Bangalore |
|  4 | Harsh  | 8978458748  | Male   |  50000 |    15000 |      2200 |       2000 |      1600 |  10000 | 2022-04-05 |       | Analyst    | Bangalore |
+----+--------+-------------+--------+--------+----------+-----------+------------+-----------+--------+------------+-------+------------+-----------+
4 rows in set (0.00 sec)

