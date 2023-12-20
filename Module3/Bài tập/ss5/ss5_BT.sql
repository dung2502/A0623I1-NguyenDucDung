create database demo;

use demo;

create table products(
id int auto_increment,
productCode varchar(30),
productName varchar(30),
productPrice double,
productAmount int,
productDescription text,
productStatus varchar(20),
primary key(id)
);


insert into products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
values ('POH1', 'Laptop', 999.99, 500, 'S', 'Available'),
('POH2', 'Macbook', 1999.99, 273, 'D', 'Available'),
('POH3', 'Samsung galaxy', 499.99, 0, 'T', 'Sold Out'),
('POH4', 'Iphone promax 14', 999.99, 999, 'E', 'Available'),
('POH5', 'Nitendo Switch', 299.99, 32, 'J', 'Available');

select* from products;
explain select * from products;

create unique index index_produceCode on products(productCode);
create index index_info_proNamePrice on products(productName, productPrice);
select * from products;
explain select * from products where productCode = 'POH2';
explain select * from products where productName = 'Laptop' and productPrice between 500 and 2000;

create view products_view as select productCode, productName, productPrice, productStatus from products;
select * from products_view;

delimiter //
create procedure productInfo()
begin
	select * from products;
end //
delimiter ;

call productInfo();

delimiter //
create procedure insertProduct(
in i_productCode varchar(30),
in i_productName varchar(30),
in i_productPrice double,
in i_productAmount int,
in i_productDescription text,
in i_productStatus varchar(20))
begin
	insert into products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
	values(i_productCode, i_productName, i_productPrice, i_productAmount, i_productDescription, i_productStatus);
 end //
 delimiter ;
 
 call insertProduct('POH123', 'Xioami MRXD 15', 2000, 10, 'P', 'Available');
 select * from products;
 
 
delimiter //
create procedure updateProduct(
in in_id int,
in i_productCode varchar(30),
in i_productName varchar(30),
in i_productPrice double,
in i_productAmount int,
in i_productDescription text,
in i_productStatus varchar(20))
begin
	update products set
    productCode = i_productCode,
    productName = i_productName,
    productPrice = i_productPrice,
    productAmount = i_productAmount,
	productDescription = i_productDescription,
	productStatus = i_productStatus
    where id = in_id;
 end //
 delimiter ;
 
call updateProduct(5, 'POH5', 'NOKIA', 299, 1, 'P', 'Sold Out');
select * from products;


delimiter //
create procedure deleteProduct(
in in_id int)
begin
	delete from products where id = in_id;
 end //
 delimiter ;

call insertProduct('POH99', 'SS Watch ss', 20, 300, 'Sw', 'Available');
select * from products;

call deleteProduct(5);
select * from products;
update products set id = 5 where id = 6;
update products set id = 6 where id = 7;
select * from products;

 
 
