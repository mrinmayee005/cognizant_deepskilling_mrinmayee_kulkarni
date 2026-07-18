-- ============================================================
-- Exercise 2: Top Rated Events
-- ============================================================
-- Identify events with the highest average rating, considering
-- only events that have received at least 10 feedback entries.
--
-- Approach:
--   GROUP BY event_id
--   HAVING COUNT(*) >= 10
--   AVG(rating) DESC
-- ============================================================

USE community_portal;

SELECT
    e.event_id,
    e.title,
    COUNT(f.feedback_id) AS total_feedbacks,
    ROUND(AVG(f.rating), 2) AS avg_rating
FROM
    Events e
    INNER JOIN Feedback f ON e.event_id = f.event_id
GROUP BY
    e.event_id, e.title
HAVING
    COUNT(f.feedback_id) >= 10
ORDER BY
    avg_rating DESC;
