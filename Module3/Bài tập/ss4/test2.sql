use quanlysinhvien;

select address, count(studentID) as 'So luong hoc vien'
from student
group by address;

select s.studentID, s.studentName, avg(mark)
from student s join mark m on s.studentID = m.studentID
group by s.studentID, s.studentName;

select student.studentID, student.studentName, avg(mark)
from student join mark on student.studentID =  mark.studentID
group by student.studentID, student.studentName
having avg(mark) > 15;

select student.studentID, student.studentName, avg(mark)
from student join mark on student.studentID =  mark.studentID
group by student.studentID, student.studentName
having avg(mark) >= all (select avg(mark) from mark group by mark.studentID);