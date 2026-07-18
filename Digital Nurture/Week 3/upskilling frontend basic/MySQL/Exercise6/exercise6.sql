-- ============================================================
-- Exercise 6: Event Resource Summary
-- ============================================================
-- For each event, show the number of resources broken down
-- by type (PDFs, images, links).
--
-- Approach:
--   GROUP BY event_id, resource_type
--   COUNT for each group
-- ============================================================

USE community_portal;

SELECT
    e.event_id,
    e.title,
    res.resource_type,
    COUNT(res.resource_id) AS resource_count
FROM
    Events e
    INNER JOIN Resources res ON e.event_id = res.event_id
GROUP BY
    e.event_id, e.title, res.resource_type
ORDER BY
    e.event_id, res.resource_type;
