# Write your MySQL query statement below
DELETE FROM Person
WHERE id not in (
    SELECT id FROM (
        SELECT MIN(id) AS id from Person
        GROUP BY email
    ) AS Temp
);

-- Synced seamlessly with LeetHub Pro
-- Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
-- Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna