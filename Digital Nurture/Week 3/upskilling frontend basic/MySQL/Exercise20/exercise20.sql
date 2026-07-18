-- ============================================================
-- Exercise 20: User Engagement Index
-- ============================================================
-- For each user, show how many events they attended and how
-- many feedback entries they submitted.
--
-- Approach:
--   COUNT of Registrations and COUNT of Feedback per user
--   LEFT JOIN to include users with no registrations/feedback
-- ============================================================

USE community_portal;

SELECT
    u.user_id,
    u.full_name,
    u.city,
    COUNT(DISTINCT r.event_id) AS events_attended,
    COUNT(DISTINCT f.feedback_id) AS feedbacks_submitted
FROM
    Users u
    LEFT JOIN Registrations r ON u.user_id = r.user_id
    LEFT JOIN Feedback f ON u.user_id = f.user_id
GROUP BY
    u.user_id, u.full_name, u.city
ORDER BY
    events_attended DESC, feedbacks_submitted DESC;
