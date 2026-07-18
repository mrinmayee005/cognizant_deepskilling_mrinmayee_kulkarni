-- ============================================================
-- Exercise 8: Sessions per Upcoming Event
-- ============================================================
-- Show all upcoming events along with the count of sessions
-- scheduled for each.
--
-- Approach:
--   LEFT JOIN Events with Sessions
--   WHERE status = 'upcoming'
--   GROUP BY event_id
-- ============================================================

USE community_portal;

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS session_count
FROM
    Events e
    LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE
    e.status = 'upcoming'
GROUP BY
    e.event_id, e.title
ORDER BY
    session_count DESC;
