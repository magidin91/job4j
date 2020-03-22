--1.Написать запрос получение всех продуктов с типом "СЫР"
Select p.id,p.name, p.expired_date, p.price from product as p
Inner join type as t On p.type_id = t.id
where t.name= 'СЫР';
--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
Select* from product
where name like '%мороженное%';
--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
Select* from product
where expired_date between '2020-04-01' and '2020-04-30' ;
--4. Написать запрос, который выводит самый дорогой продукт.
Select* from product where price = (Select Max(price) from product);
--5. Написать запрос, который выводит количество всех продуктов определенного типа.
Select count(*) from product as p
Inner join type as t On p.type_id = t.id
where t.name= 'СЫР';
--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
Select p.id,p.name, p.expired_date, p.price from product as p
Inner join type as t On p.type_id = t.id
where t.name in ('СЫР','МОЛОКО');
--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
Select t.name from product as p
Inner join type as t On p.type_id = t.id
Group by t.name having count(*)<10;
--8. Вывести все продукты и их тип.
Select p.id,p.name, p.expired_date, p.price,t.name as type from product as p
Inner join type as t On p.type_id = t.id;