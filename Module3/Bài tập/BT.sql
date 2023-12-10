create database CungCapHang;

use cungcaphang;


create table DONDH(
	SoDH int primary key,
    NgayDH varchar(100),
    MaVTU int
);

create table NhaCC(
	MaNCC int primary key,
    TenNCC varchar(100),
    DiaChi varchar(100),
    SDT varchar(100),
    SoDH int,
    foreign key(SoDH) references DONDH(SoDH)
    
);

create table VatTu(
	MaVTU int primary key,
    TenVTU varchar(100),
    SoDH int,
    SoPX int,
    SoPN int
);



create table PHIEUNHAP (
	SoPN int primary key,
    NgayNhap date,
    MaVTU int
);

create table PHIEUXUAT (
	SoPX int primary key,
    NgayXuat date,
    MaVTU int
);

create table CHITIETPHIEUNHAP(
	MaVTU int,
    SoPN int ,
    primary key ( MaVTU, SoPN),
    foreign key(MaVTU) references VatTu(MaVTU),
    foreign key(SoPN) references PHIEUNHAP(SoPN)
);

create table CHITIETDONDATHANG(
	SoDH int ,
    MaVTU int ,
    foreign key(MaVTU) references VatTu(MaVTU),
    foreign key(SoDH) references DONDH(SoDH),
    primary key(SoDH, MaVTU)
);


create table CHITIETPHIEUXUAT(
	MaVTU int ,
    SoPX int ,
	foreign key(MaVTU) references VatTu(MaVTU),
    foreign key(SoPX) references PHIEUXUAT(SoPX),
    primary key (MaVTU, SoPX)
);




drop database cungcaphang;