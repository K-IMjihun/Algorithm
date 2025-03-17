-- 코드를 입력하세요
SELECT * from FOOD_PRODUCT
    where price = (SELECT MAX(PRICE) FROM FOOD_PRODUCT)