-- ============================================================
-- Exercise 1: User Upcoming Events
-- ============================================================
-- Show a list of all upcoming events a specific user is
-- registered for in their city, sorted by start date.
--
-- Approach:
--   JOIN Users -> Registrations -> Events
--   Filter by status = 'upcoming' and matching city
--   ORDER BY start_date
-- ============================================================

USE community_portal;

SELECT
    u.user_id,
    u.full_name,
    u.city,
    e.event_id,
    e.title,
    e.start_date,
    e.end_date
FROM
    Users u
    INNER JOIN Registrations r ON u.user_id = r.user_id
    INNER JOIN Events e ON r.event_id = e.event_id
WHERE
    e.status = 'upcoming'
    AND u.city = e.city
    AND u.user_id = 1
ORDER BY
    e.start_date ASC;
