package com.example.onetomany;

import java.io.Reader;
import java.text.MessageFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HelloWord {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
 
	static {
		try {
			reader = Resources.getResourceAsReader("com/example/onetomany/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// add the interface to reomve .xml file
			//sqlSessionFactory.getConfiguration().addMapper(IPerson.class);
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
            

        } finally {
            session.close();
        }
    }

   
}

