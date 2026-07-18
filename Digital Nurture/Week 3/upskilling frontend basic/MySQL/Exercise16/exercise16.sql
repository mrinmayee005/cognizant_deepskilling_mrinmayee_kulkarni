-- ============================================================
-- Exercise 16: Unregistered Active Users
-- ============================================================
-- Find users who created their account in the last 30 days
-- but have not registered for any events yet.
--
-- Approach:
--   LEFT JOIN Users with Registrations
--   WHERE registration_date >= 30 days ago AND no registrations
-- ============================================================

USE community_portal;

SELECT
    u.user_id,
    u.full_name,
    u.email,
    u.city,
    u.registration_date
FROM
    Users u
    LEFT JOIN Registrations r ON u.user_id = r.user_id
WHERE
    u.registration_date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
    AND r.registration_id IS NULL
ORDER BY
    u.registration_date DESC;
