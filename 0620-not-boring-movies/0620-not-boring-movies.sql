# Write your MySQL query statement below
# Write your MySQL query statement below

SELECT *
FROM cinema c
WHERE c.id % 2!=0 
    AND 
    c.description != 'boring'
ORDER BY c.rating DESC;