-- ============================================================
-- Exercise 7: Low Feedback Alerts
-- ============================================================
-- Find users who gave a rating lower than 3, along with
-- their comments and the associated event names.
--
-- Approach:
--   JOIN Feedback, Users, Events
--   WHERE rating < 3
-- ============================================================

USE community_portal;

SELECT
    f.feedback_id,
    u.full_name,
    u.email,
    e.title AS event_name,
    f.rating,
    f.comments,
    f.feedback_date
FROM
    Feedback f
    INNER JOIN Users u ON f.user_id = u.user_id
    INNER JOIN Events e ON f.event_id = e.event_id
WHERE
    f.rating < 3
ORDER BY
    f.rating ASC;
