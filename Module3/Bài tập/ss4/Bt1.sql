use quanlysinhvien;

select * from subject_learn
where credit = (select max(Credit) from subject_learn);

select subject_learn.* from subject_learn
join  mark on subject_learn.SubID = mark.SubId
where mark.mark = (select max(mark) from mark);

select student.*, avg(mark) as AverageMark
from student join mark on student.studentID = mark.StudentId
group by student.studentID
ORDER BY AverageMark DESC
