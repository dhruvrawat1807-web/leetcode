# Write your MySQL query statement below
SELECT e.name
FROM employee e
JOIN employee emp
ON e.id = emp.managerId
GROUP BY e.id, e.name
HAVING COUNT(emp.id) >= 5