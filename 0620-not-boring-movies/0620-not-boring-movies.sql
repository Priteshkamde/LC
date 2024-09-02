/* Write your PL/SQL query statement below */



select id, movie, description, rating from cinema
where mod(id,2) != 0 and description not like 'boring'
order by rating desc;