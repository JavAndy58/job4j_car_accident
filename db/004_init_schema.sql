insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$hWVJmnBPS3.Em8rzda/5/uRUQGS2kV5ZXHbaaowO/R63RDDfZ2/u',
        (select id from authorities where authority = 'ROLE_ADMIN'));