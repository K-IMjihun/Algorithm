SELECT 
    COUNT(DATE_FORMAT(TIME, '%c')) AS FISH_COUNT, 
    CAST(DATE_FORMAT(TIME, '%c') AS UNSIGNED) AS MONTH
    FROM FISH_INFO
    GROUP BY MONTH
    ORDER BY MONTH