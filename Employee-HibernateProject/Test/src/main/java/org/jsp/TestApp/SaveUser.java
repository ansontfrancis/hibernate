package org.jsp.TestApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUser 
{
	public static void main(String[] args) 
	{
		Employee e=new Employee();
		Scanner s=new Scanner(System.in);
		System.out.println("enter name: ");
		String name=s.next();
		System.out.println("enter desg: ");
		String desg=s.next();
		System.out.println("enter email: ");
		String email=s.next();
		System.out.println("enter password: ");
		String password=s.next();
		System.out.println("enter phone: ");
		int phone=s.nextInt();
		System.out.println("enter salary: ");
		int salary=s.nextInt();
		e.setName(name);
		e.setDesg(desg);
		e.setPhone(phone);
		e.setEmail(email);
		e.setPassword(password);
		e.setSalary(salary);
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		manager.persist(e);
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println("Record inserted with id ="+e.getId());
		
		s.close();
		
	}

}
