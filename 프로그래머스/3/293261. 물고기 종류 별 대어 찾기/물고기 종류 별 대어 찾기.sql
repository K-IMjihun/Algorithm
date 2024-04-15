SELECT FI.ID, FNI.FISH_NAME, FI.LENGTH
    FROM FISH_INFO AS FI
    INNER JOIN FISH_NAME_INFO AS FNI
    ON FI.FISH_TYPE = FNI.FISH_TYPE
    WHERE (FI.FISH_TYPE, FI.LENGTH) IN (SELECT FISH_TYPE, 
                                            MAX(LENGTH)             
                                            FROM FISH_INFO
                                            GROUP BY FISH_TYPE)ORDER BY 1;

