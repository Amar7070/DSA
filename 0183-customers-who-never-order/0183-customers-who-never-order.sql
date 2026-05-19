# Write your MySQL query statement below
SELECT c.name as Customers FROM Customers c left join Orders o on c.id = o.customerId
where o.id is NULL;

-- Synced seamlessly with LeetHub Pro
-- Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
-- Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna