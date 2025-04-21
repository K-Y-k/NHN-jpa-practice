-- 현재 런타임의 resources에 관련 sql이 있어 충돌 현상이 발생한다.
-- 런타임에 data.sql을 지워주거나 application.properties에 각 환경의 profile을 따로 설정해주어야 한다.
insert into "user" (id, password, age)
values ('admin', '12345', 30),
       ('minjoong', '67890', 20);
