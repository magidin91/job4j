/*Нужно написать SQL скрипты:
Создать структур данных в базе.
Таблицы.
Кузов. Двигатель, Коробка передач.
Создать структуру Машина. Машина не может существовать без данных из п.1.
Заполнить таблицы через insert. */

create database cars_list;
\c cars_list;
create table engines (
	id serial primary key,
	engine varchar(200),
	model varchar(200)
);
create table car_bodies (
	id serial primary key,
	car_body varchar(200),
	model varchar(200)
);
create table transmissions (
	id serial primary key,
	transmission varchar(200),
	model varchar(200)
);
create table cars (
	id serial primary key,
	brand varchar(200),
	model varchar(200),
	engine_id int references engines(id),
	car_body_id int references car_bodies(id),
	transmissions_id int  references transmissions(id)
);
insert into engines (engine,model) values ('petrol','A4'),('diesel','BMW 5'),('electric','Tesla X');
insert into car_bodies (car_body,model) values ('coupe','A4'),('hardtop','BMW 5'),('hatchback','Tesla X');
insert into transmissions (transmission,model) values ('auto','A4'),('manual','BMW 5'),('variator','Tesla X');
insert into cars (brand,model,engine_id,car_body_id,transmissions_id) values ('Audi', 'A4',1,1,1 ),('BMW','5',2,2,2 );
--select*from cars;

--1. Вывести список всех машин и все привязанные к ним детали.
Select c.brand, c.model, e.engine,e.model,cb.car_body,cb.model,t.transmission,t.model from cars as c
Inner join engines as e on c.engine_id = e.id
Inner join car_bodies as cb on c.car_body_id = cb.id
Inner join transmissions as t on c.transmissions_id = t.id;

--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
Select e.id, e.engine, e.model from engines as e
Left Outer Join cars as c on c.engine_id = e.id where c.engine_id is null ;

Select cb.id, cb.car_body, cb.model from car_bodies as cb
Left Outer Join cars as c on c.car_body_id = cb.id where car_body_id is null ;

Select t.id, t.transmission, t.model from transmissions as t
Left Outer Join cars as c on c.transmissions_id = t.id where c.transmissions_id is null ;