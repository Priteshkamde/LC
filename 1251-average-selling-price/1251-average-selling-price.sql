/* Write your PL/SQL query statement below */

select p.product_id,  nvl(round ( (sum( p.price * us.units ) / sum (us.units)) , 2),0) as average_price
from prices p 
left join UnitsSold us
on p.product_id = us.product_id
 and us.purchase_date BETWEEN p.start_date and p.end_date
group by p.product_id;
