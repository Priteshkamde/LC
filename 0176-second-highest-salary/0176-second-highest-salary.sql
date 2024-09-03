/* Write your PL/SQL query statement below */


-- select max(salary) as "SecondHighestSalary" from Employee 
-- where salary < (
-- select max(salary) from Employee)
-- ;


-- select salary as "SecondHighestSalary" from (
-- select salary, rank() over (order by salary desc) as sal_rank from Employee
--     where salary is not null
--     ) ranked 
    
--     where sal_rank = 2;
    
    
WITH CTE AS
			(SELECT Salary, DENSE_RANK () OVER (ORDER BY Salary desc) AS RANK_desc
			   FROM Employee)
SELECT MAX(salary) AS SecondHighestSalary
  FROM CTE
 WHERE RANK_desc = 2