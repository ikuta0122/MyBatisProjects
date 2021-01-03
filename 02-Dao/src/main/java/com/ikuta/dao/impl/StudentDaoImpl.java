package com.ikuta.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.ikuta.dao.StudentDao;
import com.ikuta.po.Student;
import com.ikuta.utils.MyBatisUtils;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
	@Override
	public List<Student> selectStudents() {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		// 获取sql语句
		String sqlId = "com.ikuta.dao.StudentDao.selectStudents";
		// 执行sql语句
		List<Student> students = sqlSession.selectList(sqlId);
		// 关闭SqlSession对象
		sqlSession.close();
		return students;
	}

	@Override
	public int insertStudent(Student student) {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		// 获取sql语句
		String sqlId = "com.ikuta.dao.StudentDao.insertStudent";
		// 执行sql语句
		int nums = sqlSession.insert(sqlId, student);
		// 提交事务
		sqlSession.commit();
		// 关闭
		sqlSession.close();
		return nums;
	}
}
