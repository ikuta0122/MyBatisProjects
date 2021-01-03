package com.ikuta.dao;

import java.util.List;

import com.ikuta.po.Student;

public interface StudentDao {
	// 模糊查询的第一种方式:在java代码中指定 like的内容
	List<Student> selectLike1(String name);

	// 模糊查询的第二种方式:在mapper文件中指定like的内容
	List<Student> selectLike2(String name);
}
