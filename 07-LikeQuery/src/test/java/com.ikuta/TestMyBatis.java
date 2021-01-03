package com.ikuta;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ikuta.dao.StudentDao;
import com.ikuta.po.Student;
import com.ikuta.utils.MyBatisUtils;

public class TestMyBatis {
	// 模糊查询的第一种方式:在java代码中指定 like的内容
	@Test
	public void testSelectLike1() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		String name = "李%";
		List<Student> students = dao.selectLike1(name);
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}

	// 模糊查询的第二种方式:在mapper文件中指定like的内容
	@Test
	public void testSelectLike2() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		String name = "李";
		List<Student> students = dao.selectLike2(name);
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
		sqlSession.close();
	}
}
