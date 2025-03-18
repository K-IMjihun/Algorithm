-- 코드를 입력하세요
SELECT CAR_TYPE, count(*) as CARS
    from CAR_RENTAL_COMPANY_CAR
    WHERE OPTIONS like '%통풍시트%' OR
          OPTIONS like '%열선시트%' OR
          OPTIONS like '%가죽시트%'
    group by CAR_TYPE
order by car_type;