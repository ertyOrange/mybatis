package com.example.onetable;

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
			reader = Resources.getResourceAsReader("com/example/onetable/mybatis-config.xml");
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
            //sqlSessionFactory.getConfiguration().addMapper(IUser.class);
            //User user = (User) session.selectOne( "com.yiibai.mybatis.models.UserMapper.getUserByID", 1);

            // 用户数据列表
        	getPersons();
            // 插入数据
             //testInsert();

            // 更新用户
            //testUpdate();

            // 删除数据
            //testDelete();

        } finally {
            session.close();
        }
    }

    //
    public static void testInsert()
    {
        try
        {
            // 获取Session连接
            SqlSession session = sqlSessionFactory.openSession();
            // 获取Mapper
            IPerson personMapper = session.getMapper(IPerson.class);
            System.out.println("Test insert start...");
            // 执行插入
            Person person = new Person();
            person.setId(0);
            person.setName("Google");
            person.setDept("Tech");
            person.setWebsite("http://www.google.com");
            person.setPhone("120");
            personMapper.insertPerson(person);
            // 提交事务
            session.commit();

            // 显示插入之后User信息
            System.out.println("After insert");
            getPersons();
            System.out.println("Test insert finished...");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // 获取用户列表
    public static void getPersons() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            IPerson personMapper = session.getMapper(IPerson.class);
            // 显示User信息
            System.out.println("Test Get start...");
            printPersons(personMapper.getPersonList());
            System.out.println("Test Get finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testUpdate()
    {
        try
        {
            SqlSession session = sqlSessionFactory.openSession();
            IPerson personMapper = session.getMapper(IPerson.class);
            System.out.println("Test update start...");
            printPersons(personMapper.getPersonList());
            // 执行更新
            Person person = personMapper.getPerson(1);
            person.setName("New name");
            personMapper.updatePerson(person);
            // 提交事务
            session.commit();
            // 显示更新之后User信息
            System.out.println("After update");
            printPersons(personMapper.getPersonList());
            System.out.println("Test update finished...");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // 删除用户信息
    public static void testDelete()
    {
        try
        {
            SqlSession session = sqlSessionFactory.openSession();
            IPerson personMapper = session.getMapper(IPerson.class);
            System.out.println("Test delete start...");
            // 显示删除之前User信息
            System.out.println("Before delete");
            printPersons(personMapper.getPersonList());
            // 执行删除
            personMapper.deletePerson(2);
            // 提交事务
            session.commit();
            // 显示删除之后User信息
            System.out.println("After delete");
            printPersons(personMapper.getPersonList());
            System.out.println("Test delete finished...");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 
     * 打印用户信息到控制台
     * 
     * @param users
     */
    private static void printPersons(final List<Person> persons) {
        int count = 0;

        for (Person person : persons) {
            System.out.println(MessageFormat.format(
                    "============= Person[{0}]=================", ++count));
            System.out.println("Person Id: " + person.getId());
            System.out.println("Person Name: " + person.getName());
            System.out.println("Person Dept: " + person.getDept());
            System.out.println("Person Website: " + person.getWebsite());
        }
    }
}

