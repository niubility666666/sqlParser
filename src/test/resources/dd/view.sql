CREATE VIEW V_EMP_30
AS
SELECT
  EMPNO,
  ENAME,
  SAL
FROM EMP
WHERE DEPTNO = 30;

DROP VIEW V_EMP_30;