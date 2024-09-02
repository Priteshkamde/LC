/* Write your PL/SQL query statement below */

-- select P.product_name, S.year, S.price from Sales S
-- inner join Product P on P.product_id = S.product_id;


with sales_details as 
 (  
    select P.product_name, S.year, S.price 
    from Sales S
    inner join Product P 
    on P.product_id = S.product_id;
 )
 
 select product_name, year, price from sales_details;