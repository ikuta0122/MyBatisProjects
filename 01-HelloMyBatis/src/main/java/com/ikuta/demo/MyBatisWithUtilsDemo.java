package com.ikuta.demo;

import com.ikuta.po.Student;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class MyBatisWithUtilsDemo {
	public static void main(String[] args) throws IOException {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		// 获取sql语句
		String sqlId = "com.ikuta.dao.StudentDao.selectStudents";
		// 执行sql语句
		List<Student> studentList = sqlSession.selectList(sqlId);
		// 输出结果
		studentList.forEach(stu -> System.out.println(stu));
		// 关闭SqlSession对象
		sqlSession.close();
	}
}
