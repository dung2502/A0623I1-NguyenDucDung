package com.codegym.a0623i1.repositories.impl;

import com.codegym.a0623i1.models.Student;
import com.codegym.a0623i1.repositories.IStudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "haiTT", 7.0, "12312312", 1));
        students.add(new Student(2, "haiTT2", 3.0, "12312312", 2));
        students.add(new Student(3, "haiTT3", 6.0, "12312312", 1));
        students.add(new Student(4, "haiTT4", 8.0, "12312312", 3));
        students.add(new Student(5, "haiTT5", 5.0, "12312312", 1));
    }


    @Override
    public List<Student> findAll() {
        List<Student> list = BaseRepository.entityManager.
                createQuery("select s from  students s where id = :id", Student.class).setParameter("id", 1).getResultList();
        return list;
    }
    @Override
    public void save(Student student) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(student);
        entityTransaction.commit();
    }
}
