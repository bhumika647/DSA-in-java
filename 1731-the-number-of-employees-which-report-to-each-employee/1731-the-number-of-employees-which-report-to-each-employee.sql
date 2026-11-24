# Write your MySQL query statement below
# Write your MySQL query statement below
select m.employee_id,m.name, 
count(e.reports_to) as reports_count,
round(avg(e.age)) as average_age
from Employees e
left join employees m
on e.reports_to=m.employee_id
where e.reports_to is not null
group by e.reports_to
order by employee_id