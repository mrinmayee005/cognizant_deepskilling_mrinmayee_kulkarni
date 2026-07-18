-- ============================================================
-- Exercise 21: Top Feedback Providers
-- ============================================================
-- Find the top 5 users who submitted the most feedback entries.
--
-- Approach:
--   GROUP BY user_id
--   COUNT(*)
--   ORDER BY count DESC
--   LIMIT 5
-- ============================================================

USE community_portal;

SELECT
    u.user_id,
    u.full_name,
    u.email,
    COUNT(f.feedback_id) AS feedback_count
FROM
    Users u
    INNER JOIN Feedback f ON u.user_id = f.user_id
GROUP BY
    u.user_id, u.full_name, u.email
ORDER BY
    feedback_count DESC
LIMIT 5;
