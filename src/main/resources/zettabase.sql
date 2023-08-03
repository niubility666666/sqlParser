create schema s1;

create schema IF NOT EXISTS s2;

create schema s3 authorization user2;

create schema s4 engine pontus;

create schema s5 xx yy zz;

DROP TABLE if exists dept cascade;

create table t1(id int);

create table t1(id int) engine pontus;

create table t1(id int) order by (id);

CREATE TABLE dept(
    deptno Integer NOT NULL,
    dname VARCHAR(20) NOT NULL,
    loc VARCHAR(20)) PONTUS_TABLE_DEPT;

create table t1 like t2;

create table t3 as select * from t4;

create table public.t1(c1 integer);

select * from t1;
select c1 from t1;
select t1.c1 from s1.t1;
select t.c1 from cat1.sch1.t1 as t;

SELECT * FROM USERS WHERE AGE > 30 AND SALARY = 50000;

select * from users where age > 30 and salary = 5000;

select t1.c1, t2.c2 from t1, t2 where t1.id = t2.id;

select t1.c1, t2.c2 from t1 join t2 on t1.id=t2.id;

select c1, (select max(id) from t1) from t2;

select count(*) from (select id,name from users where groupid=1000) x;

select c1 from t1 union select c2 from t2;

select c1 from t1 union all select c2 from t2;



