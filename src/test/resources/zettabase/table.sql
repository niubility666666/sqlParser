
create table t1(id int);

-- not work
create table t1(id int) engine pontus;

-- not work
create table t1(id int) order by (id);

DROP TABLE T1;

DROP TABLE S1.T1;

DROP TABLE C1.S1.T1;

-- TODO: not work
DROP TABLE if exists dept cascade;

-- TODO: not work
DROP TABLE DEPT RESTRICT;

-- alter table name
ALTER TABLE EMP RENAME TO EMP2;

ALTER TABLE C1.S1.EMP RENAME TO C1.S1.EMP2;

-- alter table properties(TODO: not work)
ALTER TABLE EMP SET PROPERTIES ('replicas':'4');

ALTER TABLE C1.S1.EMP SET PROPERTIES ('replicas':'4', 'min_replicas':'2');

-- alter table add column(TODO: not work)
ALTER TABLE EMP ADD COLUMN C2 INT NOT NULL DEFAULT 10 BEFORE C1;

-- alter table drop column
ALTER TABLE EMP DROP COLUMN C1;

-- alter table modify column
ALTER TABLE EMP ALTER COLUMN SAL RENAME TO SAL_TEST;

ALTER TABLE EMP ALTER COLUMN C2 SET DATA TYPE SMALLINT;

ALTER TABLE TEST_ALTER ALTER COLUMN a SET DEFAULT 1;

ALTER TABLE TEST_ALTER ALTER COLUMN a DROP DEFAULT;

ALTER TABLE TEST_ALTER alter column a set not null;

ALTER TABLE TEST_ALTER alter column a set null;