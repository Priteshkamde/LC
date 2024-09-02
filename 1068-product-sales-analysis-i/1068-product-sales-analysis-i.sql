/* Write your PL/SQL query statement below */

-- select P.product_name, S.year, S.price from Sales S
-- join Product P on P.product_id = S.product_id;

WITH SaleDetails AS (
    SELECT 
        s.sale_id,
        p.product_name,
        s.year,
        s.price
    FROM 
        Sales s
    JOIN 
        Product p ON s.product_id = p.product_id
)
SELECT 
    product_name,
    year,
    price
FROM 
    SaleDetails;