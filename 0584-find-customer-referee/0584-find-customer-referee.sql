/* Write your PL/SQL query statement below */
SELECT name
FROM Customer
WHERE COALESCE(referee_id,0) <> 2;