-- ============================================================
-- Exercise 24: Average Session Duration per Event
-- ============================================================
-- Calculate the average session duration (in minutes) for
-- each event.
--
-- Approach:
--   TIMESTAMPDIFF(MINUTE, start_time, end_time)
--   AVG(duration), GROUP BY event_id
-- ============================================================

USE community_portal;

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS total_sessions,
    ROUND(AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)), 2) AS avg_duration_minutes,
    ROUND(MIN(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)), 2) AS min_duration_minutes,
    ROUND(MAX(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)), 2) AS max_duration_minutes
FROM
    Events e
    INNER JOIN Sessions s ON e.event_id = s.event_id
GROUP BY
    e.event_id, e.title
ORDER BY
    avg_duration_minutes DESC;
