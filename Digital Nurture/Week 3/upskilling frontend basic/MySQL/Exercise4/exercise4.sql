-- ============================================================
-- Exercise 4: Peak Session Hours
-- ============================================================
-- Count the number of sessions scheduled between 10 AM and
-- 12 PM (i.e., hours 10 and 11) for each event.
--
-- Approach:
--   WHERE HOUR(start_time) BETWEEN 10 AND 11
--   GROUP BY event_id
-- ============================================================

USE community_portal;

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS sessions_in_peak_hours
FROM
    Events e
    INNER JOIN Sessions s ON e.event_id = s.event_id
WHERE
    HOUR(s.start_time) BETWEEN 10 AND 11
GROUP BY
    e.event_id, e.title
ORDER BY
    sessions_in_peak_hours DESC;
