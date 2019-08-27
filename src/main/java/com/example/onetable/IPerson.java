/**
 * 
 */
/**
 * @author yy263
 *
 */
package com.example.onetable;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface IPerson {
	
	//@Select("select * from person")
	public List<Person> getPersonList();

	public void insertPerson(Person person);

	public void updatePerson(Person person);

	public void deletePerson(int personId);

	public Person getPerson(int id);

}