-- 기본 clathpath인 resources 폴더 안에 schema.sql 명칭이 있으면
-- 스프링이 스키마 관련 sql로 인식하고 실행해준다.

-- h2는 InMemoryDB 라서 실행을 종료시킬 때 스키마가 모두 날아간다.
-- 나이 추가
create table if not exists `user`
(
    id       varchar(50) not null,
    password varchar(50) not null,
    age int not null,
    primary key (id)
);
