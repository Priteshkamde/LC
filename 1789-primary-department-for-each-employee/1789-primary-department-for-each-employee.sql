/* Write your PL/SQL query statement below */


select employee_id, department_id as from Employee
where (primary_flag = 'Y') or (employee_id in (select employee_id from employee
                                              group by employee_id having count(department_id)=1))
;