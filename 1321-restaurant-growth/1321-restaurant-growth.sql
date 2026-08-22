SELECT visited_on, amount, ROUND(amount/7,2) average_amount
FROM (
    SELECT visited_on,
           SUM(SUM(amount)) OVER(ORDER BY visited_on ROWS 6 PRECEDING) amount,
           ROW_NUMBER() OVER(ORDER BY visited_on) rn
    FROM Customer
    GROUP BY visited_on
) t
WHERE rn >= 7;