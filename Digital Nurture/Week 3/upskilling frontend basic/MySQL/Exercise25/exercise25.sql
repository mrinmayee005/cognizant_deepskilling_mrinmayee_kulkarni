-- ============================================================
-- Exercise 25: Events Without Sessions
-- ============================================================
-- Find events that have no sessions scheduled.
--
-- Approach:
--   LEFT JOIN Events with Sessions
--   WHERE session_id IS NULL
-- ============================================================

USE community_portal;

SELECT
    e.event_id,
    e.title,
    e.city,
    e.status,
    e.start_date,
    e.end_date
FROM
    Events e
    LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE
    s.session_id IS NULL
ORDER BY
    e.start_date;
