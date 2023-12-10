create database QuanLySinhVien;

use Quanlysinhvien;

create table Class(
	ClassID int not null auto_increment primary key,
    ClassName varchar (60) not null,
    StartDate date not null,
    Status_Class bit
);



create table student(
	studentID int not null auto_increment primary key,
    studentName varchar(20) not null,
    Address varchar(10),
    Phone varchar(50),
    status_student BIT,
    ClassID int not null,
    foreign key (ClassID) references Class(ClassID)
);

create table Subject_learn (
	SubID int not null auto_increment primary key,
    SubName varchar(30) not null,
    Credit tinyint not null default 1 check ( Credit >= 1),
    Status_subject bit default 1
);

CREATE TABLE Mark
(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject_learn (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);

