create database users_and_roles;
\c users_and_roles;
create table roles (
id serial primary key,
role_name varchar(200)
);
create table users (
id serial primary key,
user_name varchar(200),
role_id int references roles(id)
);
create table rules (
id serial primary key,
rule_descriprion varchar(2000)
);
create table role_rule (
id serial primary key,
role_id int references roles(id),
rule_id int references rules(id)
);
create table category (
id serial primary key,
category varchar(200)
);
create table state (
id serial primary key,
state varchar(200)
);
create table item (
id serial primary key,
item varchar(2000),
user_id int references users(id),
category_id int references category(id),
state_id int references state(id)
);
create table comments (
id serial primary key,
comment text,
item_id int references item(id)
);
create table attaches (
id serial primary key,
attach varchar(2000),
item_id int references item(id)
);
insert into roles (role_name) values ('some_role1'),('some_role2');
insert into rules (rule_descriprion) values ('some_rule1'),('some_rule2');
insert into role_rule (role_id,rule_id) values (1,1),(1,2),(2,1);
insert into users (user_name,role_id) values ('Jack Jones', 1),('Jone Bill', 2);
insert into category (category) values ('category1'),('category2');
insert into state (state) values ('state1'),('state2');
insert into item (item, user_id, category_id , state_id ) values ('item1', 1, 1,1),('item2', 2, 2,2);
insert into comments (comment,item_id) values ('comment1', 1),('comment2', 1),('comment3', 2);
insert into attaches (attach,item_id) values ('attach1', 1),('attach2', 1),('attach3', 2);
