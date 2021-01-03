package com.ikuta.dao;

import java.util.List;

import com.ikuta.po.Student;

public interface StudentDao {

    List<Student> selectStudents();

    int insertStudent(Student student);
}

