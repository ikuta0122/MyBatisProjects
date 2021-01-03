package com.ikuta.dao;

import com.ikuta.po.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectStudents();

    int insertStudent(Student student);
}

