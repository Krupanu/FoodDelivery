INSERT INTO online_food_order.users
VALUES
    (1,'user@test.com','User','Test','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','USER'),
    (2,'admin@test.com','Admin','Test','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','ADMIN');

INSERT INTO online_food_order.food
VALUES
    (1, 'Pizza', 9.99),
    (2, 'Burger', 5.99),
    (3, 'Sushi', 12.99);

INSERT INTO online_food_order.orders
VALUES
    (1,'PENDING', 1),
    (2,'APPROVED', 2);

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