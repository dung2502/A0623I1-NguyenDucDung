create database `bt1`;
use bt1;
create table Class (
	id int,
    name_class varchar(100),
    primary key(id)
);

create table Teacher (
	id int,
    name_teacher varchar(100),
    age int,
    country varchar(100)
)