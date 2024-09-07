WITH RECURSIVE Gen AS (
    -- 1세대 (PARENT_ID가 NULL인 경우)
    SELECT ID, PARENT_ID, 1 AS generation
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL

    UNION ALL

    -- 자식 세대
    SELECT e.ID, e.PARENT_ID, g.generation + 1
    FROM ECOLI_DATA e
    JOIN Gen g ON e.PARENT_ID = g.ID
)

SELECT ID
FROM Gen
WHERE generation = 3
ORDER BY ID;
