-- ============================================================
-- Exercise 10: Feedback Gap
-- ============================================================
-- Find events that had registrations but received no feedback.
--
-- Approach:
--   Start with Registrations
--   LEFT JOIN Feedback
--   WHERE feedback_id IS NULL
-- ============================================================

USE community_portal;

SELECT DISTINCT
    e.event_id,
    e.title,
    e.status,
    COUNT(r.registration_id) AS total_registrations
FROM
    Events e
    INNER JOIN Registrations r ON e.event_id = r.event_id
    LEFT JOIN Feedback f ON e.event_id = f.event_id
WHERE
    f.feedback_id IS NULL
GROUP BY
    e.event_id, e.title, e.status
ORDER BY
    e.event_id;
