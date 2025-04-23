insert into item (id, name, price)
values (1, 'apple', 300),
       (2, 'grape', 200),
       (3, 'banana', 150),
       (4, 'cherry', 250),
       (5, 'kiwi', 400),
       (6, 'lemon', 250),
       (7, 'lime', 250),
       (8, 'mango', 350),
       (9, 'orange', 200),
       (10, 'peach', 300),
       (11, 'melon', 100);

insert into "order" (id, ordered_at)
values (1, '2018-08-23 10:30:00'),
       (2, '2018-08-24 21:15:30');

insert into order_item ("order_id", line_number, item_id, quantity)
values (1, 1, 1, 3),
       (1, 2, 2, 1),
       (1, 3, 3, 2),
       (2, 1, 4, 1),
       (2, 2, 5, 1),
       (2, 3, 6, 2),
       (2, 4, 7, 1),
       (2, 5, 8, 5),
       (2, 6, 9, 1);
