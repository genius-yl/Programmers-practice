-- 서울에 위치한 식당 목록 출력하기
SELECT A.REST_ID, A.REST_NAME, A.FOOD_TYPE, A.FAVORITES, A.ADDRESS, ROUND(AVG(CAST(REVIEW_SCORE AS DOUBLE)), 2) AS SCORE
from (
    select * from REST_INFO
    where ADDRESS like '서울%'
) as A join (
    select * from REST_REVIEW 
) as B on A.REST_ID=B.REST_ID
group by A.REST_ID, A.REST_NAME, A.FOOD_TYPE, A.ADDRESS
order by score desc, favorites desc;
