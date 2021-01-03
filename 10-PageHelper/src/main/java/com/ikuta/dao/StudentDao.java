package com.ikuta.dao;

import com.ikuta.po.Student;

import java.util.List;

public interface StudentDao {
	// 使用PageHelper分页数据
	List<Student> selectAll();
}
