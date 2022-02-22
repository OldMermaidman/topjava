DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (user_id, datetime, description, calories)
VALUES (100000, now(), 'еда админа 1', 500),
       (100000, now(), 'еда админа 2', 600),
       (100000, now(), 'еда админа 3', 700),
       (100000, now(), 'еда админа 4', 800),
       (100001, now(), 'еда юзера 1', 100),
       (100001, now(), 'еда юзера 2', 200),
       (100001, now(), 'еда юзера 3', 300),
       (100001, now(), 'еда юзера 4', 400),
       (100001, now(), 'еда юзера 5', 500);
