/* Write your PL/SQL query statement below */

-- select e1.name from employee e1 where id in (
--     select managerId
--     from employee
--     group by managerId
--     having count(*) > 4
-- );

select m.name
from employee e 
inner join employee m 
    on e.managerId = m.id
group by e.managerId, m.name
having count(*) >= 5;