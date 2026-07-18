-- ============================================================
-- Exercise 9: Organizer Event Summary
-- ============================================================
-- For each organizer, show the total number of events and a
-- breakdown by status (upcoming, completed, cancelled).
--
-- Approach:
--   GROUP BY organizer_id
--   Conditional COUNT for each status value
-- ============================================================

USE community_portal;

SELECT
    u.user_id AS organizer_id,
    u.full_name AS organizer_name,
    COUNT(e.event_id) AS total_events,
    SUM(CASE WHEN e.status = 'upcoming' THEN 1 ELSE 0 END) AS upcoming_count,
    SUM(CASE WHEN e.status = 'completed' THEN 1 ELSE 0 END) AS completed_count,
    SUM(CASE WHEN e.status = 'cancelled' THEN 1 ELSE 0 END) AS cancelled_count
FROM
    Users u
    INNER JOIN Events e ON u.user_id = e.organizer_id
GROUP BY
    u.user_id, u.full_name
ORDER BY
    total_events DESC;
