package com.ikuta;

import com.ikuta.dao.StudentDao;
import com.ikuta.po.Student;
import com.ikuta.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyBatis {
	@Test
	public void testSelectStudentIf() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student student = new Student();
		student.setName("李四");
		student.setAge(18);
		List<Student> students = dao.selectStudentIf(student);
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
	}

	@Test
	public void testSelectStudentWhere() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student student = new Student();
		student.setName("李四");
		student.setAge(18);
		List<Student> students = dao.selectStudentWhere(student);
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
	}

	@Test
	public void testSelectForEachOne() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		List<Integer> list = new ArrayList<>();
		list.add(1001);
		list.add(1002);
		list.add(1003);
		List<Student> students = dao.selectForeachOne(list);
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
	}

	@Test
	public void testSelectForEachTwo() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		// 准备数据
		List<Student> stuList = new ArrayList<>();
		Student student1 = new Student();
		student1.setId(101);
		stuList.add(student1);
		Student student2 = new Student();
		student2.setId(102);
		stuList.add(student2);
		List<Student> students = dao.selectForeachTwo(stuList);
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
	}
}
