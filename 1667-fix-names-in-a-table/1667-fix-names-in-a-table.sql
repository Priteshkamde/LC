/* Write your PL/SQL query statement below */

select user_id, substr(upper(name), 1, 1) || substr(lower(name), 2, length(name)) as name
from Users
order by user_id;