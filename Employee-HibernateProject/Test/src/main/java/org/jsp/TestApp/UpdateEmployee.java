package org.jsp.TestApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateEmployee 
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter the id to update the details:");
		int id=s.nextInt();
		System.out.println("enter name: ");
		String name=s.next();
		System.out.println("enter desg: ");
		String desg=s.next();
		System.out.println("enter email: ");
		String email=s.next();
		System.out.println("enter phone no: ");
		int phone=s.nextInt();
		System.out.println("enter password: ");
		String password=s.next();
		System.out.println("enter salary: ");
		int salary=s.nextInt();
		Employee e=new Employee();
		e.setId(id);
		e.setName(name);
		e.setDesg(desg);
		e.setEmail(email);
		e.setPhone(phone);
		e.setPassword(password);
		e.setSalary(salary);
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		manager.merge(e);
		transaction.begin();
		transaction.commit();
		s.close();
	}
	
	

}
