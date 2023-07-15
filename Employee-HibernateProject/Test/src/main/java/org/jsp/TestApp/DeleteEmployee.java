package org.jsp.TestApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteEmployee {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter the id to delete the details");
		int id=s.nextInt();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Employee e=manager.find(Employee.class, id);
		if (e!=null)
		{
			manager.remove(e);
			transaction.begin();
			transaction.commit();
		}
		else
		{
			System.err.println("invalid id entered!! please try with valid id");
		}
		s.close();
	}
}
