use QuanLySinhVien;

INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
INSERT INTO Student (StudentName, Address, Phone, status_student, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, status_student, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, status_student, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO Subject_learn
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       
 
SELECT *
FROM Student;
       
SELECT *
FROM Student
WHERE status_student = true;

SELECT *
FROM Subject_learn
WHERE Credit < 10;

SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S 
join Class C on S.ClassId = C.ClassID;

SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S 
join Class C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';

SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S 
join Mark M on S.StudentId = M.StudentId join Subject_learn Sub on M.SubId = Sub.SubId;

SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject_learn Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';

select * from student 
where student.studentname like "h%";

select * from class 
where class.startdate like "%12%";

select class.*
from class
where month(StartDate) = 12;

select * from subject_learn
where credit between 3 and 5;

update  student
set classID = 2
where studentName = "Hung"
limit 1;

select student.studentName, subject_learn.SubName, mark.Mark from
student
join mark on student.studentID = mark.studentID
join subject_learn on mark.subid = subject_learn.subid
order by mark.mark desc, student.studentname asc;



       
       
       
       
       