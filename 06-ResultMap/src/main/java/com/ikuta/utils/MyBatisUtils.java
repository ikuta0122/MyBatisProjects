package com.ikuta.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
	private static SqlSessionFactory factory = null;

	static {
		// config的值设置为主配置文件的文件名
		String config = "mybatis.xml"; 
		try {
			InputStream in = Resources.getResourceAsStream(config);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取SqlSession的方法
	 * 
	 * @return 表示返回SqlSession对象
	 */
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		if (factory != null) {
			// 该SqlSession对象非自动提交事务
			sqlSession = factory.openSession();
		}
		return sqlSession;
	}
}
