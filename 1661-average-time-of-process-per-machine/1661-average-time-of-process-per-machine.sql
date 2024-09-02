/* Write your PL/SQL query statement below */


select M1.machine_id, round(avg(M2.timestamp-M1.timestamp),3) 
as "processing_time"
from Activity M1
join Activity M2
    on M1.machine_id = M2.machine_id 
    and M1.process_id = M2.process_id
    and M1.timestamp < M2.timestamp
group by M1.machine_id
;