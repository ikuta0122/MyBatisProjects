package com.ikuta.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ikuta.vo.ViewStudent;

public interface StudentDao {
	// 定义方法返回java对象
	ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

	// 定义方法返回简单类型
	int countStudent();

	// 定义方法返回Map
	Map<Object, Object> selectMapById(Integer id);
}
