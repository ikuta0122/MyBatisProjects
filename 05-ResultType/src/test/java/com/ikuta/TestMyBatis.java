package com.ikuta;

import com.ikuta.dao.StudentDao;
import com.ikuta.utils.MyBatisUtils;
import com.ikuta.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Map;

public class TestMyBatis {
	@Test
	public void testSelectViewStudent() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		ViewStudent student = dao.selectStudentReturnViewStudent(102);
		System.out.println("1002 student=" + student);
		sqlSession.close();
	}

	@Test
	public void testSelectCount() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		int counts = dao.countStudent();
		System.out.println("学生数量=" + counts);
		sqlSession.close();
	}

	@Test
	public void testSelecMap() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		Map<Object, Object> map = dao.selectMapById(101);
		System.out.println("map==" + map);
		sqlSession.close();
	}
}
