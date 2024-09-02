/* Write your PL/SQL query statement below */

select e1.name from employee e1 where id in (
    select managerId
    from employee
    group by managerId
    having count(*) > 4
);