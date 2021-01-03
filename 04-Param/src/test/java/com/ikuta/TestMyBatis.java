package com.ikuta;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ikuta.dao.StudentDao;
import com.ikuta.po.Student;
import com.ikuta.utils.MyBatisUtils;
import com.ikuta.vo.QueryParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {
	@Test
	public void testSelectStudentById() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student student = dao.selectStudentById(1001);
		System.out.println("student = " + student);
		sqlSession.close();
	}

	@Test
	public void testSelectMultiParam() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		List<Student> students = dao.selectMultiParam("李四", 20);
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}

	@Test
	public void testSelectMultiObject() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		QueryParam param = new QueryParam();
		param.setParamName("张三");
		param.setParamAge(28);
		List<Student> students = dao.selectMultiObject(param);
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}

	@Test
	public void testSelectMultiStudent() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Student student = new Student();
		student.setName("张三");
		student.setAge(28);
		List<Student> students = dao.selectMultiStudent(student);
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}

	@Test
	public void testSelectMultiPosition() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		List<Student> students = dao.selectMultiPosition("李四", 20);
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}

	@Test
	public void testSelectMultiByMap() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Map<String, Object> data = new HashMap<>();
		data.put("nameofmap", "张三");
		data.put("ageofmap", 28);
		List<Student> students = dao.selectMultiByMap(data);
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}

	@Test
	public void testSelectUse$() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		List<Student> students = dao.selectUse$("'李四' or age='20'");
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}

	@Test
	public void testSelectUse$Order() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		List<Student> students = dao.selectUse$Order("age");
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}
}
