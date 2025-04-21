-- 기본 clathpath인 resources 폴더 안에 data.sql 명칭이 있으면
-- 스프링이 데이터 관련 sql로 인식하고 실행해준다.

-- 나이 추가
insert into `user`(id, password, age)
values ('admin', '12345', 10),
       ('minjoong', '67890', 40);
