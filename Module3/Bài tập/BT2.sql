create database quanlydiemthi;
use quanlydiemthi;

create table HocSinh(
	MaHS varchar(100) primary key,
    TenHS varchar(100),
    NgaySinh date,
    Lop varchar(20),
    GT varchar(20)
);
create table GiaoVien(
	MaGV varchar(100) primary key,
    TenGV varchar(100),
    SDT varchar(100)
);
create table MonHoc(
	MaMH varchar(100) primary key,
    TenMH varchar(100),
    MaGV varchar(100),
    foreign key(MaGV) references GiaoVien(MaGV)
);

create table BangDiem(
	MaHS varchar(100),
    MaMH varchar(100),
    DiemThi int,
    primary key(MaHS, MaMH),
    foreign key(MaHS) references HocSinh(Mahs),
    foreign key(MaMH) references MonHoc(MaMH)
);


