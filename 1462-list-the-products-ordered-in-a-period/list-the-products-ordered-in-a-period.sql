# Write your MySQL query statement SELECT
  

    SELECT
        p.product_name,
        SUM(o.unit) AS unit
    FROM products p
     LEFT JOIN  orders o
    ON p.product_id = o.product_id
    WHERE order_date >= '2020-02-01'
      AND order_date < '2020-03-01'
    GROUP BY p.product_id
    HAVING sum(o.unit) >= 100;