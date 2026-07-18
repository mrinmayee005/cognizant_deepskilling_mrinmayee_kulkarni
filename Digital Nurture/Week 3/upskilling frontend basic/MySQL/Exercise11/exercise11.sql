-- ============================================================
-- Exercise 11: Daily New User Count
-- ============================================================
-- Show the number of users who registered each day over the
-- last 7 days.
--
-- Approach:
--   WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)
--   GROUP BY registration_date
-- ============================================================

USE community_portal;

SELECT
    registration_date,
    COUNT(*) AS new_user_count
FROM
    Users
WHERE
    registration_date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)
GROUP BY
    registration_date
ORDER BY
    registration_date ASC;
