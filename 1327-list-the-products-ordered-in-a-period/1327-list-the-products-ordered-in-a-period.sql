/* Write your PL/SQL query statement below */


-- select p.product_name, sum(unit) as unit 
-- from Products p 
-- join Orders o 
-- on p.product_id = o.product_id
-- where EXTRACT(MONTH FROM order_date) = 2
--   AND EXTRACT(YEAR FROM order_date) = 2020;
-- group by product_name
-- having sum(unit) >=100;

select p.product_name as product_name ,
 sum(o.unit) as unit
from Products p inner join Orders o
on p.product_id = o.product_id
where o.order_date>='2020-02-01'
AND o.order_date <'2020-03-01'
group by p.product_name
having sum(unit) >= 100