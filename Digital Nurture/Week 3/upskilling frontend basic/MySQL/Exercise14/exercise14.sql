-- ============================================================
-- Exercise 14: Most Registered Events
-- ============================================================
-- Find the top 3 events based on total registrations.
--
-- Approach:
--   JOIN Registrations, Events
--   GROUP BY event_id
--   COUNT(*), LIMIT 3
-- ============================================================

USE community_portal;

SELECT
    e.event_id,
    e.title,
    e.city,
    e.status,
    COUNT(r.registration_id) AS total_registrations
FROM
    Events e
    INNER JOIN Registrations r ON e.event_id = r.event_id
GROUP BY
    e.event_id, e.title, e.city, e.status
ORDER BY
    total_registrations DESC
LIMIT 3;
