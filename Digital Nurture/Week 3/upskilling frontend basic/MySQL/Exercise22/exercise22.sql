-- ============================================================
-- Exercise 22: Duplicate Registrations Check
-- ============================================================
-- Detect if any user has been registered more than once for
-- the same event (duplicate registrations).
--
-- Approach:
--   GROUP BY user_id, event_id
--   HAVING COUNT(*) > 1
-- ============================================================

USE community_portal;

SELECT
    r.user_id,
    u.full_name,
    r.event_id,
    e.title AS event_title,
    COUNT(*) AS registration_count
FROM
    Registrations r
    INNER JOIN Users u ON r.user_id = u.user_id
    INNER JOIN Events e ON r.event_id = e.event_id
GROUP BY
    r.user_id, u.full_name, r.event_id, e.title
HAVING
    COUNT(*) > 1
ORDER BY
    registration_count DESC;
