-- ============================================================
-- Exercise 19: Completed Events with Feedback Summary
-- ============================================================
-- For completed events, show total registrations and the
-- average feedback rating.
--
-- Approach:
--   WHERE status = 'completed'
--   JOIN Registrations and Feedback
--   GROUP BY event_id
-- ============================================================

USE community_portal;

SELECT
    e.event_id,
    e.title,
    COUNT(DISTINCT r.registration_id) AS total_registrations,
    COUNT(f.feedback_id) AS total_feedbacks,
    ROUND(AVG(f.rating), 2) AS avg_rating
FROM
    Events e
    LEFT JOIN Registrations r ON e.event_id = r.event_id
    LEFT JOIN Feedback f ON e.event_id = f.event_id
WHERE
    e.status = 'completed'
GROUP BY
    e.event_id, e.title
ORDER BY
    avg_rating DESC;
