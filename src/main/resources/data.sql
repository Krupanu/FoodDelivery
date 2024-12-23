INSERT INTO online_food_order.users
VALUES
    (1,'user@test.com','User','Test','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','USER'),
    (2,'admin@test.com','Admin','Test','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','ADMIN');

INSERT INTO online_food_order.food
VALUES
    (1, 'Смэш-бургер', 9.99),
    (2, 'Чизбургер', 5.99),
    (3, 'Чикен бургер', 12.99);

INSERT INTO online_food_order.order
VALUES
    (1,'ул. Тестовая 1','Тестовое описание 1','2025-12-14 16:46:23', 'IN_PROGRESS','Тестовый заголовок 1', 1,1),
    (2,'ул. Тестовая 2','Тестовое описание 2','2025-12-19 16:46:23', 'APPROVED','Тестовый заголовок 3', 1,1),
    (3,'ул. Тестовая 3','Тестовое описание 3','2025-06-14 16:46:23', 'DECLINED','Тестовый заголовок 4', 1,1);


INSERT INTO online_food_order.order_foods
VALUES
    (1, 1),
    (2, 3);

INSERT INTO  online_food_order.application
VALUES
      (1,'2024-12-14 16:46:23', 'IN_PROGRESS',1,1),
      (2,'2024-12-14 16:46:23','IN_PROGRESS',2,1),
      (3,'2024-12-14 16:46:23','IN_PROGRESS',2,2),
      (4,'2024-12-14 16:46:23','DECLINED',1,2);