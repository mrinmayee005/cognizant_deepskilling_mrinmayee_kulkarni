-- ============================================================
-- Exercise 17: Multi-Session Speakers
-- ============================================================
-- Find speakers who are handling more than one session across
-- all events.
--
-- Approach:
--   GROUP BY speaker_name
--   HAVING COUNT(*) > 1
-- ============================================================

USE community_portal;

SELECT
    speaker_name,
    COUNT(*) AS total_sessions,
    COUNT(DISTINCT event_id) AS across_events
FROM
    Sessions
GROUP BY
    speaker_name
HAVING
    COUNT(*) > 1
ORDER BY
    total_sessions DESC;
