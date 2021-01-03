package com.ikuta;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ikuta.po.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
	@Test
	public void testSelect() throws IOException {
		// 1.定义mybatis主配置文件的名称, 从类路径的根开始（target/clasess/主配置文件）
		String config = "mybatis.xml";
		// 2.读取这个config表示的文件
		InputStream in = Resources.getResourceAsStream(config);
		// 3.创建了SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 4.创建SqlSessionFactory对象
		SqlSessionFactory factory = builder.build(in);
		// 5.【重要】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
		SqlSession sqlSession = factory.openSession();
		// 6.【重要】指定要执行的sql语句的标识。 sql映射文件中的namespace + "." + 标签的id值
		String sqlId = "com.ikuta.dao.StudentDao.selectStudents";
		// 7. 重要】执行sql语句，通过sqlId找到语句
		List<Student> studentList = sqlSession.selectList(sqlId);
		// 8.输出结果
		for (Student stu : studentList) {
			System.out.println("查询的学生=" + stu);
		}
		// 9.关闭SqlSession对象
		sqlSession.close();
	}

	@Test
	public void testInsert() throws IOException {
		// 获取SqlSession对象，从SqlSessionFactory中获取SqlSession
		String config = "mybatis.xml";
		InputStream in = Resources.getResourceAsStream(config);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(in);
		SqlSession sqlSession = factory.openSession(true);
		// 【重要】指定要执行的sql语句的标识。 sql映射文件中的namespace + "." + 标签的id值
		String sqlId = "com.ikuta.dao.StudentDao.insertStudent";
		// 【重要】执行sql语句，通过sqlId找到语句
		Student student = new Student();
		student.setId(1006);
		student.setName("关羽");
		student.setEmail("guanyu@163.com");
		student.setAge(20);
		int nums = sqlSession.insert(sqlId, student);
		// mybatis默认不自动提交事务的,所以在insert ，update ，delete后要手工提交事务
		// sqlSession.commit();
		// 输出结果
		System.out.println("执行insert的结果=" + nums);
		// 关闭SqlSession对象
		sqlSession.close();
	}
}
