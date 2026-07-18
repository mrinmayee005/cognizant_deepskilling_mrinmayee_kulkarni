-- ============================================================
-- Exercise 3: Inactive Users
-- ============================================================
-- Find users who have not registered for any events in the
-- last 90 days (or have no registrations at all).
--
-- Approach:
--   LEFT JOIN Users with Registrations
--   Filter WHERE registration_date < 90 days ago OR NULL
-- ============================================================

USE community_portal;

SELECT
    u.user_id,
    u.full_name,
    u.email,
    u.registration_date,
    MAX(r.registration_date) AS last_registration
FROM
    Users u
    LEFT JOIN Registrations r ON u.user_id = r.user_id
GROUP BY
    u.user_id, u.full_name, u.email, u.registration_date
HAVING
    MAX(r.registration_date) < DATE_SUB(CURDATE(), INTERVAL 90 DAY)
    OR MAX(r.registration_date) IS NULL
ORDER BY
    last_registration ASC;
