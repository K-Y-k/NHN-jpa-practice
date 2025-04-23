insert into student (id, name)
values (1, 'chosun'),
       (2, 'nhn');

insert into course (id, name)
values (100, 'servlet'),
       (200, 'jpa'),
       (300, 'auth');

insert into enrollment (id, student_id, course_id, enrolled_at)
values (1, 1, 100, now()),
       (2, 1, 200, now()),

       (3, 2, 100, now()),
       (4, 2, 200, now()),
       (5, 2, 300, now());
