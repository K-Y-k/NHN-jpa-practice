-- id bigint, name varchar(255), 10 rows
insert into "member" (id, name)
values (1, '김민중'),
       (2, '홍길동'),
       (3, '김철수'),
       (4, '이영희'),
       (5, '박영희'),
       (6, '김영희'),
       (7, '이철수'),
       (8, '박철수'),
       (9, '김길동'),
       (10, '홍철수');

-- id bigint, name varchar(255), member_id bigint, 10 rows
insert into locker (id, name, "member_id")
values (1, 'A001', 1),
       (2, 'A002', 2),
       (3, 'A003', 3),
       (4, 'A004', 4),
       (5, 'A005', 5),
       (6, 'A006', 6),
       (7, 'A007', 7),
       (8, 'A008', 8),
       (9, 'A009', 9),
       (10, 'A010', 10);


