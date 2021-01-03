package com.ikuta;

import com.github.pagehelper.PageHelper;
import com.ikuta.dao.StudentDao;
import com.ikuta.po.Student;
import com.ikuta.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		StudentDao dao = sqlSession.getMapper(StudentDao.class);
		
		// 分页:加入PageHelper的方法
		PageHelper.startPage(2, 2);
		
		List<Student> students = dao.selectAll();
		for (Student stu : students) {
			System.out.println("student = " + stu);
		}
	}
}
