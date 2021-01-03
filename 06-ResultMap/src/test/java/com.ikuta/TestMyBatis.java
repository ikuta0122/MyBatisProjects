package com.ikuta;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ikuta.dao.StudentDao;
import com.ikuta.po.MyStudent;
import com.ikuta.po.Student;
import com.ikuta.utils.MyBatisUtils;

public class TestMyBatis {
	@Test
	public void testSelectAllStudents() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		List<Student> students = dao.selectAllStudents();
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}

	@Test
	public void testSelectDiffColProperty1() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		List<MyStudent> students = dao.selectDiffColProperty1();
		for (MyStudent stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}

	@Test
	public void testSelectDiffColProperty2() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		List<MyStudent> students = dao.selectDiffColProperty2();
		for (MyStudent stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}
}
