WITH Percentiles AS (
  SELECT
    ID,
    NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS Percentile
  FROM
    ECOLI_DATA
),
Classification AS (
  SELECT
    ID,
    CASE
      WHEN Percentile = 1 THEN 'CRITICAL'
      WHEN Percentile = 2 THEN 'HIGH'
      WHEN Percentile = 3 THEN 'MEDIUM'
      WHEN Percentile = 4 THEN 'LOW'
    END AS COLONY_NAME
  FROM
    Percentiles
)
SELECT
  E.ID,
  C.COLONY_NAME
FROM
  ECOLI_DATA E
JOIN
  Classification C
ON
  E.ID = C.ID
ORDER BY
  E.ID;
