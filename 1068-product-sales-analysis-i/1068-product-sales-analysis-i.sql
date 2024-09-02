/* Write your PL/SQL query statement below */

select P.product_name, S.year, S.price from Sales S
inner join Product P on P.product_id = S.product_id;
