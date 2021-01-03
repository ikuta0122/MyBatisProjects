package com.ikuta;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ikuta.dao.StudentDao;
import com.ikuta.po.Student;
import com.ikuta.utils.MyBatisUtils;

import java.util.List;

//使用MyBatis的动态代理机制
public class TestMyBatis {

	@Test
	public void testSelectStudents() {
		// 获取dao接口的实现类对象[使用SqlSession.getMapper(dao接口)]
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		// 调用dao的方法操作数据库
		List<Student> students = dao.selectStudents();
		for (Student student : students) {
			System.out.println("student = " + student);
		}
		sqlSession.close();
	}

	@Test
	public void testInsertStudent() {
		// 获取dao接口的实现类对象[使用SqlSession.getMapper(dao接口)]
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		// 调用dao的方法操作数据库
		Student student = new Student();
		student.setId(1007);
		student.setName("张飞");
		student.setEmail("zhangfei@qq.com");
		student.setAge(50);
		int nums = dao.insertStudent(student);
		sqlSession.commit();
		System.out.println("影响数据库的条数 = " + nums);
		sqlSession.close();
	}
}
