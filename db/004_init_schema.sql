insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$c6R5jXWEbTHNz.mAdfEO0.3POiMR7SNpZoOMqy4uEJb/xv5G78Myu',
        (select id from authorities where authority = 'ROLE_ADMIN'));