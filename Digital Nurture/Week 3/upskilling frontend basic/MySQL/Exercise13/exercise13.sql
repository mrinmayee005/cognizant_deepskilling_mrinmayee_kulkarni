-- ============================================================
-- Exercise 13: Average Rating per City
-- ============================================================
-- Calculate the average feedback rating for events held in
-- each city.
--
-- Approach:
--   JOIN Events, Feedback
--   GROUP BY Events.city
--   AVG(rating)
-- ============================================================

USE community_portal;

SELECT
    e.city,
    COUNT(DISTINCT e.event_id) AS total_events,
    COUNT(f.feedback_id) AS total_feedbacks,
    ROUND(AVG(f.rating), 2) AS avg_rating
FROM
    Events e
    INNER JOIN Feedback f ON e.event_id = f.event_id
GROUP BY
    e.city
ORDER BY
    avg_rating DESC;
