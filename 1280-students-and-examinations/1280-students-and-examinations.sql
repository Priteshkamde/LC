/* Write your PL/SQL query statement below */

select s.student_id, s.student_name, sb.subject_name, count(e.subject_name) as attended_exams
from students s 
cross join subjects sb
    
left outer join examinations e 
    on s.student_id = e.student_id and sb.subject_name = e.subject_name  
group by sb.subject_name, s.student_name, s.student_id
order by s.student_id, s.student_name;
