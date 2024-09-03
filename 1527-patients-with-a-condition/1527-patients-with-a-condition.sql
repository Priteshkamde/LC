/* Write your PL/SQL query statement below */

select * from patients WHERE conditions LIKE '%DIAB1%' AND conditions NOT LIKE 'SADIAB100%';