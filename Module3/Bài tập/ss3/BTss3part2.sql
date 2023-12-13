use quanlybanhang;

INSERT INTO customer(cName, cAge)
VALUES ('Minh Quan', 10);
INSERT INTO customer(cName, cAge)
VALUES ('Ngoc Oanh', 20);
INSERT INTO customer(cName, cAge)
VALUES ('Hong Ha', 30);


insert into oder(cDate, cTotalPrice)
VALUES ('2006-3-21', Null);
insert into oder(cDate, cTotalPrice)
VALUES ('2006-03-23', Null);
insert into oder(cDate, cTotalPrice)
VALUES ('2006-03-16', Null);

insert into product (pName, pPrice)
values ('May Giat', 3), ('Tu Lanh', 5), ('Dieu Hoa', 7), ('Quat', 1), ('Bep Dien', 2);

insert into oderdetail(oID, pID, odQTY)
values (1, 1, 3), (1, 3, 7), (1, 4, 2), (2, 1, 1), (3, 1, 8), (2, 5, 4), (2, 3, 3);
select oder.oId, oder.cDate, oder.cTotalPrice from oder;

select customer.cName, product.pName from customer
join oder on customer.cId = oder.cId
join oderDetail on oder.oId = oderDetail.oId
join product on oderDetail.pId = product.pId;

select customer.cName from customer
where customer.cId not in (select oder.cId from oder);

select oder.oId, oder.cDate as saleDate, sum(oderDetail.odQTY * product.pPrice) as totalPrice
from oder
join oderDetail on oder.oId = oderDetail.oId
join product on oderDetail.pId = product.pId
group by oderDetail.oId, oder.cDate;