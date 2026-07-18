-- ============================================================
-- Exercise 12: Event with Maximum Sessions
-- ============================================================
-- Find the event(s) with the highest number of sessions.
--
-- Approach:
--   Subquery: find MAX of session counts
--   Use that to filter events with that count
-- ============================================================

USE community_portal;

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS session_count
FROM
    Events e
    INNER JOIN Sessions s ON e.event_id = s.event_id
GROUP BY
    e.event_id, e.title
HAVING
    COUNT(s.session_id) = (
        SELECT MAX(session_cnt)
        FROM (
            SELECT COUNT(*) AS session_cnt
            FROM Sessions
            GROUP BY event_id
        ) AS sub
    );
