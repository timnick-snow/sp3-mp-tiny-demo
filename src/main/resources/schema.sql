create table if not exists demo_user
(
    id          bigint NOT NULL AUTO_INCREMENT,
    username    varchar(64) DEFAULT NULL COMMENT '用户名',
    age         int         DEFAULT NULL COMMENT '年龄',
    create_time datetime    DEFAULT NULL,
    PRIMARY KEY (id)
);

insert into demo_user(username, age, create_time)
values ('zs', 12, '2023-03-14 14:00:00');
insert into demo_user(username, age, create_time)
values ('ls', 13, '2023-03-15 15:00:00');
insert into demo_user(username, age, create_time)
values ('wz', 14, '2023-03-15 15:22:33');