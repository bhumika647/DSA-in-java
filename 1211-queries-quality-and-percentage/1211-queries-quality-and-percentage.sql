# Write your MySQL query statement below
SELECT DISTINCT
    query_name,
    ROUND(AVG(rating / position), 2) quality,
    ROUND(SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END) * 100 / COUNT(*), 2) poor_query_percentage 
FROM Queries
GROUP BY query_name