/* Write your PL/SQL query statement below */


SELECT s.user_id, round(avg(case when ci.action = 'confirmed' then 1 else 0 end),2) AS confirmation_rate
FROM 
    signups s
left outer join Confirmations ci
    ON s.user_id = ci.user_id
group by s.user_id;



 
