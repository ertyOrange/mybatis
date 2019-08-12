package com.example.demo.config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.models.Person;

public class HelloWord {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
 
	static {
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Person person = (Person) session.selectOne(
					"com.example.demo.models.PersonMapper.GetPersonByID", 1);
			if(person!=null){
				String userInfo = "名字："+person.getName()+", 所属部门："+person.getDept()+", 主页："+person.getWebsite();
				System.out.println(userInfo);
			}
		} finally {
			session.close();
		}
	}

}
