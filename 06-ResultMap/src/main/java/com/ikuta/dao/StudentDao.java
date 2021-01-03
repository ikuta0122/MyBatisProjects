package com.ikuta.dao;

import java.util.List;

import com.ikuta.po.MyStudent;
import com.ikuta.po.Student;

public interface StudentDao {
	// 使用resultMap定义映射关系
	List<Student> selectAllStudents();

	// 列名和属性名不同的第一种解决方案
	List<MyStudent> selectDiffColProperty1();

	// 列名和属性名不同的第二种解决方案
	List<MyStudent> selectDiffColProperty2();
}
