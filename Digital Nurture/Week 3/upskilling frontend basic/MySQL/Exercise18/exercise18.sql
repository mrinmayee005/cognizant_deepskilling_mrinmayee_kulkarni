-- ============================================================
-- Exercise 18: Resource Availability Check
-- ============================================================
-- Find events that do not have any resources uploaded.
--
-- Approach:
--   LEFT JOIN Events with Resources
--   WHERE resource_id IS NULL
-- ============================================================

USE community_portal;

SELECT
    e.event_id,
    e.title,
    e.city,
    e.status
FROM
    Events e
    LEFT JOIN Resources res ON e.event_id = res.event_id
WHERE
    res.resource_id IS NULL
ORDER BY
    e.event_id;
