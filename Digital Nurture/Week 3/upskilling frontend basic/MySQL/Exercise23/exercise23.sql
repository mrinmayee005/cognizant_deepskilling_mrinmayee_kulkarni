-- ============================================================
-- Exercise 23: Registration Trends
-- ============================================================
-- Show month-wise registration counts over the past 12 months.
--
-- Approach:
--   GROUP BY YEAR(registration_date), MONTH(registration_date)
--   Filter last 12 months
-- ============================================================

USE community_portal;

SELECT
    YEAR(registration_date) AS reg_year,
    MONTH(registration_date) AS reg_month,
    DATE_FORMAT(registration_date, '%Y-%m') AS year_month,
    COUNT(*) AS registration_count
FROM
    Registrations
WHERE
    registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY
    YEAR(registration_date),
    MONTH(registration_date),
    DATE_FORMAT(registration_date, '%Y-%m')
ORDER BY
    reg_year, reg_month;
