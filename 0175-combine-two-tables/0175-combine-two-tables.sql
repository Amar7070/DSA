# Write your MySQL query statement below
SELECT p.firstName, p.LastName, a.city, a.state FROM Person p
LEFT JOIN address a on p.personId = a.personId

-- Synced seamlessly with LeetHub Pro
-- Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
-- Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna