insert into question (title, content, created_at)
values ('질문입니다.', '내용입니다.', '2023-05-08T23:35:00Z');

insert into answer (question_id, content, created_at)
values (1, '답변입니다.', '2023-05-08T23:36:00Z'),
       (1, '또 다른 답변입니다.', '2023-05-08T23:36:30Z');
