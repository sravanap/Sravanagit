package com.sysintelli.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sysintelli.entity.Employee;

public class EmployeeDAO {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
Connection con = null;
	public void addEmployee(Employee emp) {
		
		
		try {
			if(con==null)
			con= dataSource.getConnection();
			Statement st=con.createStatement();
			((java.sql.Statement) st).execute("insert into employee values ("+emp.getId()+",'"+emp.getName()+"',"+emp.getSalary()+")");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Add");
		}
	finally {
		if (con!=null)
		try {
			con.close();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	}
	
	public void deleteEmployeeByID(int empID) {
		try {
			if(con==null)
			con= dataSource.getConnection();
			Statement st=con.createStatement();
			
			((java.sql.Statement) st).execute("delete from employee where id="+empID);  
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete");
		}
	finally {
		if (con!=null)
		try {
			con.close();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	}

	public Employee getEmployeeByID(int empID) {
		
	Employee emp= new Employee();
	int id = 0;
	String name = "";
	float Salary = 0;
	
		try {
			if(con==null)
			con= dataSource.getConnection();
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery("select * from employee where id ="+empID);
			while (rs.next()){
				id = rs.getInt("id");
			 name = rs.getString("Name");
			Salary = rs.getFloat("Salary");
			}
			
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("Name"));
			emp.setSalary(rs.getFloat("Salary"));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getall");
			
		}
		return emp;
	}
		
	
	
	

	public List<Employee> getAllEmployees() {
		ArrayList<Employee> E = new ArrayList<Employee>();

		int id = 0;
		String name = " ";
		float salary = 0;

		try {

		if (con == null) {
		con = dataSource.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employee");
		while (rs.next()) {
		       Employee em = new Employee();
		           id = rs.getInt("id");
		           name = rs.getString("name");
		          salary = rs.getFloat("salary");
		em.setId(id);
		em.setName(name);
		em.setSalary(salary);

		E.add(em);
		}
		}

		} catch (Exception e) {
		// TODO: handle exception
		}
		return E;
		}
	}




