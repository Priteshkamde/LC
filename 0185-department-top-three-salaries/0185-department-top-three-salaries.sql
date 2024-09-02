/* Write your PL/SQL query statement below */


WITH RankedSalaries AS (
    SELECT 
        d.name AS department, 
        e.name AS employee, 
        e.salary as salary, 
        DENSE_RANK() OVER (PARTITION BY d.name ORDER BY e.salary DESC) AS sal_rank
    FROM 
        employee e
    JOIN 
        department d 
    ON 
        d.id = e.departmentid
)
SELECT department, employee, salary
FROM RankedSalaries
WHERE sal_rank <= 3;
