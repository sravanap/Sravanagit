package com.sysintelli.application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sysintelli.dao.EmployeeDAO;
import com.sysintelli.entity.Employee;

public class Application {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
		EmployeeDAO e = (EmployeeDAO) context.getBean("empDao");
		Employee emp= (Employee) context.getBean("empid");
		//int id = emp.getId();
		//e.getEmployeeByID(id);
	//System.out.println("emp");
	//System.out.println(e.getEmployeeByID(id));
		List<Employee>Ems= new ArrayList<Employee>();
		Ems =e.getAllEmployees();//
	for( Employee et:Ems){
		System.out.println("ID:"+et.getId());
		System.out.println("name :"+et.getName());
		System.out.println("salary :"+et.getSalary());
		}

			}

}
