package com.ikuta.dao;

import com.ikuta.po.Student;

import java.util.List;

//接口操作student表
public interface StudentDao {
    /**
     * 查询方法
     *
     * @return 表示执行select操作后的得到Java对象
     */
	List<Student> selectStudents();

    /**
     * 插入方法
     *
     * @param student 表示要插入到数据库的数据
     * @return 表示执行insert操作后的影响数据库的行数
     */
	int insertStudent(Student student);
}
