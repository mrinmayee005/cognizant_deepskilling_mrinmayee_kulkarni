-- ============================================================
-- Exercise 5: Most Active Cities
-- ============================================================
-- Find the top 5 cities with the highest number of distinct
-- user registrations for events.
--
-- Approach:
--   JOIN Users, Registrations
--   GROUP BY city
--   COUNT(DISTINCT user_id)
--   LIMIT 5
-- ============================================================

USE community_portal;

SELECT
    u.city,
    COUNT(DISTINCT r.user_id) AS distinct_users_registered
FROM
    Users u
    INNER JOIN Registrations r ON u.user_id = r.user_id
GROUP BY
    u.city
ORDER BY
    distinct_users_registered DESC
LIMIT 5;
