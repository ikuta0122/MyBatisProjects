package com.ikuta;

import org.junit.Test;

import com.ikuta.dao.StudentDao;
import com.ikuta.dao.impl.StudentDaoImpl;
import com.ikuta.po.Student;

import java.util.List;

public class TestMyBatis {

	@Test
	public void testSelectStudents() {
		StudentDao dao = new StudentDaoImpl();
		// MyBatis的动态代理： MyBatis根据引用dao的方法调用,获取执行sql语句的信息。
		// MyBatis根据dao接口,创建出一个dao接口的实现类,并创建这个类的对象来完成SqlSession调用方法访问数据库。
		List<Student> studentList = dao.selectStudents();
		for (Student stu : studentList) {
			System.out.println(stu);
		}
	}

	@Test
	public void testInsertStudent() {
		StudentDao dao = new StudentDaoImpl();
		Student student = new Student();
		student.setId(105);
		student.setName("盾山");
		student.setEmail("dunshan@qq.com");
		student.setAge(20);
		int nums = dao.insertStudent(student);
		System.out.println("添加对象的数量：" + nums);
	}

}
