package com.ikuta.dao;

import com.ikuta.po.Student;

import java.util.List;

public interface StudentDao {
	// 动态SQL之if
	List<Student> selectStudentIf(Student student);

	// 动态SQL之where
	List<Student> selectStudentWhere(Student student);

	// 动态SQL之foreach[用法1:简单类型]
	List<Student> selectForeachOne(List<Integer> idlist);

	// 动态SQL之foreach[用法2:java对象]
	List<Student> selectForeachTwo(List<Student> stulist);

}
