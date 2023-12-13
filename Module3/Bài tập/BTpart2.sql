create database QuanLyBanHang;

use QuanLyBanHang;

create table customer(
	cID int primary key AUTO_INCREMENT,
    cName varchar(50),
    cAge varchar(50)
);

create table oder(
	oID int primary key AUTO_INCREMENT,
    cID int,
    cDate date,
    cTotalPrice varchar(50),
	foreign key(cID) references customer(cID)
);

create table product(
	pID int primary key AUTO_INCREMENT,
    pName varchar(50),
    pPrice varchar(50)
);

create table oderdetail(
	oID int ,
    pID int,
    odQTY int,
    primary key ( oID, pID),
	foreign key(oID) references oder(oID),
	foreign key(pID) references product(pID)
);

drop database quanlybanhang;
